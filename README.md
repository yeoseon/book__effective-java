# 아이템 01. 생성자 대신 정적 팩터리 메서드를 고려하라  

## 클라이언트가 클래스의 인스턴스를 얻는 방법 2가지  

1. public 생성자를 이용한다. 
2. 정적 팩터리 메서드를 이용한다. 

(예) ```boolean``` 값을 받아 ```Boolean``` 객체 참조로 변환해주는 메서드
```
public static boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;
}
```

## 정적 팩토리 메서드를 사용하면 좋은 점  

### 1. 이름을 가질 수 있다.  

정적 팩토리 메서드는 이름을 잘 지으면 반환될 객체의 특성을 쉽게 묘사할 수 있다.  

(예) 값이 소수인 BigInteger를 반환한다.  
```
BigInteger.probablePrime();
```

**한 클래스에 시그니처가 같은 생성자가 여러 개 필요할 것 같으면, 생성자는 정적 팩토리 메서드로 바꾸고 각각의 차이를 잘 드러내는 이름을 지어주자**  

### 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.  

불변 클래스 (Immuable class)는 인스턴스를 미리 만들어놓거나 새로 생성한 인스턴스를 캐싱하여 재활용하는 방식으로 불필요한 객체 생성을 피할 수 있다.  

**생성 비용이 큰 같은 객체가 자주 요청되는 상황이라면, 성능을 상당히 끌어올려 줄 수 있다.**  

[Flyweight Pattern](https://github.com/yeoseon/design-patterns/tree/master/Flyweight#flyweight) 도 이와 비슷한 기법이라고 할 수 있다.  

#### 인스턴스 통제 클래스

반복 요청에 대해 같은 객체를 반환하는 식으로 정적 팩토리 방식의 클래스는 언제 어느 인스턴스를 살아있게 할지를 통제할 수 있다.  
인스턴스를 통제하게 되면 싱글턴으로 만들 수도, 인스턴스화 불가(noninstantiable)로 만들 수도 있다.  
불변 클래스에서 동치인 인스턴스가 단 하나 뿐임을 보장할 수 있다. (a == b일 때만 a.equals(b)가 성립)  
인스턴스 통제는 Flyweight 패턴의 근간이 되며, [열거 타입](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-34-int-%EC%83%81%EC%88%98-%EB%8C%80%EC%8B%A0-%EC%97%B4%EA%B1%B0-%ED%83%80%EC%9E%85%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%9D%BC)은 인스턴스가 하나만 만들어짐을 보장한다.  

### 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.  

**엄청난 유연성**  

이 유연성을 응용하게 되면, **구현 클래스를 공개하지 않고도 그 객체를 반환할 수 있어 API를 작게 유지할 수 있다.**  

이는 **인터페이스를 정적 팩터리 메서드의 반환 타입으로 사용하는 인터페이스 기반 프레임워크**를 만드는 핵심 기술이기도 하다.  

### 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.  

반환타입의 하위 타입이기만 하면 어떤 클래스의 객체를 반환하든 상관 없다.  

(예) EnumSet 클래스는 public 생성자 없이 오직 정적 팩터리만 제공하는데, 원소의 수에 따라 두 가지 하위 클래스 중 하나의 인스턴스를 반환한다.  
원소가 64개 이하면 long 변수 하나로 관리하는 RegularEnumSet 인스턴스를 반환하고, 그 이상이면 long 배열로 관리하는 JumboEnumSet의 인스턴스를 반환한다.  
**클라이언트는 이 두 클래스의 존재를 모른다.**  
다음 릴리즈 때 RegularEnumSet의 이점이 사라진다면, 삭제해도 아무 문제가 없어질 것이다.  
**클라이언트는 팩터리가 건네주는 객체가 어느 클래스의 인스턴스인지 알 필요가 없다.**  

### 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

[서비스 제공자 프레임워크](https://github.com/yeoseon/tip-archive/issues/197)를 만드는 근간이 된다.  

## 정적 팩토리 메서드를 사용하면 나쁜 점  

### 1. 상속을 하려면 public 이나 protented 생성자가 필요하니, 정적 팩터리만 제공할 경우 하위 클래스를 만들 수 없다.  

앞서 이야기 한 컬랙션 프레임워크의 유틸리티 구현 클래스들은 상속할 수 없다는 이야기이다.  
상속보다 컴포지션을 사용하도록 유도하고, 불변 타입으로 만들려면 이 제약을 지켜야 한다는 점에서 오히려 장점으로 받아들일 수도 있다.  

### 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.  

API 설명에 명확히 드러나지 않는다.  
javadoc이 아직은 처리해주지 못하고 있다.  
그러므로 [알려진 규약](https://github.com/yeoseon/tip-archive/issues/198)을 따라 짓는 식으로 문제를 완화 하자.  

## 정리  

정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인 장단점을 이해하고 사용하는 것이 좋다.  
하지만 정적 팩터리를 사용하는 것이 유리한 경우가 더 많으므로 무작정 public 생성자를 제공하던 습관이 있다면 고쳐보자.  

# 아이템 04. 인스턴스화를 막으려거든 private 생성자를 사용하라.  

정적 메소드와 정적 필드만을 담은 클래스를 만들 때  

* ```java.lang.Math```, ```java.util.Arrays``` 기본 타입 값이나 배열 관련 메서드들을 모아놓은 클래스 (유틸성..)  
* ```java.util.Collections``` 처럼 특정 인터페이스를 구현하는 객체를 생성해주는 정적 메서드를 모아놓은 클래스  
* ```final``` 클래스와 관련한 메서드를 모아놓은 클래스  

유틸성 클래스는 인스턴스로 만들어 쓰려고 설계한 클래스가 아니다.  
하지만 생성자를 명시하지 않으면, 컴파일러가 자동으로 기본 생성자를 만들어준다.  
이 경우 의도치않게 인스턴스화가 가능하도록 클래스가 만들어지는 경우가 있다.  

## 추상 클래스로 만드는 것으로는 인스턴스화를 막을 수 없다.  

하위 클래스를 만들어 인스턴스화하면 되기 때문이다.  
상속이 가능하다는 말도 되니 더 문제가 발생한다.  

## ```private``` 생성자를 추가하자.  

```
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }
}
```

* private 생성자이므로, 외부에서 접근할 수 없다.  
* ```AssertionError```를 통해 클래스 내부에서도 생성자를 호출하지 않도록 해준다.  
* 생성자가 존재하는데 호출할 수 없는 구조이므로 적절한 주석을 통해 동료들에게 설명할 수 있도록 해주자.  
* 상속 또한 불가능하게 된다.  

# 아이템 06. 불필요한 객체 생성을 피하라  

똑같은 기능의 객체를 매번 생성하기 보다는 객체 하나를 재사용 하는 편이 나을 때가 많다.  
특히 불변 객체는 언제든 재사용할 수 있다.  

## 예시 1  
```
String s = new String("bikini");    // 절대 하지 말 것  
```
* 위의 코드는 실행될 때마다 ```String``` 인스턴스를 새로 만든다.  
* 생성자에 넘겨진 ```"bikini"``` 자체가 이 생성자로 만들어내려는 ```String```과 기능적으로 완전히 똑가기 때문에 매우 쓸데없는 행위이다.  

```
String s = "bikini";  
```

* 다음과 같이 사용하여, 매번 새로운 인스턴스를 만드는 대신 하나의 ```String``` 인스턴스를 사용해야 한다.  
* **같은 가상머신 안에서 이와 똑같은 문자열 리터럴을 사용하는 모든 코드가 같은 객체를 재사용함이 보장된다.**  

## 정적 팩터리 메서드를 사용해보자.  

생성자 대신 정적 팩터리 메서드를 제공하는 불변 클래스에서는 이를 통해 불필요한 객체 생성을 피할 수 있다.  

```Boolean(String)``` 생성자 대신 ```Boolean.valudOf(String)``` 팩터리 메서드를 사용하는 것이 좋다. (그래서 이 생성자는 ```deprecated``` 처리 되었다.)  

가변객체라고 해도, 변하지 않을 것을 보장한다면 재사용할 수 있다.  

## 생성 비용이 아주 비싼 객체도 있다.  

비싼 객체가 반복해서 필요하다면 캐싱하여 재사용하는 것이 좋다.  

### 예시 2  

```
static boolean isRomanNumeral(String s) {
    return s.matches("[정규식]");
}
```
* 이 방식은 ```String.matches```를 사용하는 것에 문제가 있따.  
* 이 방식은 성능이 중요한 상황에서 반복해 사용하기에 적절치 않다.  
* 이 API 내부에서 만드는 ```Pattern``` 인스턴스는 유한 상태머신을 만들기 때문에 인스턴스 생성 비용이 비싸다.  
* 이를 해결하기 위해 Pattern 객체를 상수로 선언하여 사용하도록 한다.  
* 상수로 Pattern을 분리하여 재사용하게 된다면 코드도 더 명확해지게 된다.  

## 불필요한 객체를 만들어내는 또 다른 예 : 오토 박싱  

프로그래머가 기본 타입과 박싱된 기본 타입을 섞어 쓸 때 자동으로 상호 변환해주는 기술  

**기본 타입과 그에 대응하는 박싱된 기본 타입의 구분을 흐려주지만, 완전히 없애주는 것은 아니다.**  

### 예시 3  
```
private static long sum() {
    Long sum = 0L;
    for(long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
    }

    return sum;
}
```
* 위의 소스코드가 정확한 답을 내기는 한다.  
* sum 변수를 ```long```이 아닌 ```Long```으로 선언하는 바람에 불필요한 ```Long```인스턴스가 약 231개가 만들어진다.  

**박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의하자.**  

## 정리  

프로그램의 명확성, 간결성, 기능을 위해서 객체를 추가로 생성하는 것이라면 일반적으로 좋은 일이다.  
그렇다고 자체 객체 풀을 만들지 말자. 이는 코드를 헷갈리게 만들고 메모리 사용량을 늘리고 성능을 떨어뜨린다.  

방어적 복사와는 대조적이다.  
방어적 복사가 필요한 상황에서 객체를 재사용했을 때의 피해가, 필요없는 객체를 반복 생성했을 때의 피해보다 훨씬 크다는 사실을 기억하자.  
불필요한 객체생성은 그저 코드 형태와 성능에만 영향을 준다.  


# 아이템 14. Comparable 구현을 고려하라  
(Effective Java 내용 정리 필요)  

## 관련 Refactoring 예시  

### 예시 1  

> LottoNumber 가 Comparable 을 구현하였는데 getValue() 로 값을 꺼내올 필요가 있을까요? (https://github.com/next-step/java-lotto/pull/404#discussion_r399871346 참고)  

Comparable을 구현했다는 것은 equals, hashCode 등을 오버라이딩하여 재구현했다는 말.  
따라서 getValue를 통해 실제 값을 가져와 비교해줄 필요가 없다.  

### 예시 2

> 객체지향의 핵심 중 하나인 **정보은닉**을 고려해보자. 원시값을 접근할 수 있다면, 외부에서 add와 같은 기능을 통해 원시값을 제어할 수 있는 위험이 생긴다. 따라서 getValue()를 통해 값을 가져오는 것을 지양하고, Comparable을 구현하여 객체로 소통할 수 있도록 사용하는 것이 좋다. 

관련 Comment  
* https://github.com/next-step/java-bowling/pull/116#discussion_r409315783  
* https://github.com/next-step/java-bowling/pull/135#discussion_r411826450  

## [Java Comparable.compareTo(T o) 문서](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)에서 권고하는 사항

### 권고사항 4. ```(x.compareTo(y)==0) == (x.equals(y))```를 만족시키도록 구현해라.  

> It is strongly recommended, but not strictly required that (x.compareTo(y)==0) == (x.equals(y)). Generally speaking, any class that implements the Comparable interface and violates this condition should clearly indicate this fact. The recommended language is "Note: this class has a natural ordering that is inconsistent with equals."  

매우 강력하게 지킬 것을 권장하고 있다.  
이 규칙을 위반하면 이상하고 예측할 수 없는 오류가 발생할 수 있다.  
예를 들어, Java 5 에서는 PriorityQueue.remove() 메소드는 compareTo()에 의존했지만, Java 6 부터는 equals()에 의존했다.  

따라서, compareTo를 오버라이딩 했을 때는, equals도 오버라이딩 해주어야 한다.  

# 아이템 17. 변경 가능성을 최소화하라.  

**불변 클래스**란 그 인스턴스의 내부 값을 수정할 수 없는 클래스이다.  
객체가 파괴되는 순간까지 절대 달라지지 않는다. 

```String```, ```박싱 클래스```, ```BigInteger```, ```BigDecimal``` 등이 있다.  

불변클래스는 가변 클래스보다 설계하고 구현하고 사용하기 쉽다.  
오류가 생길 여지가 적어 훨씬 안전하다.  

## 클래스를 불변으로 만들기 위한 다섯 가지 규칙  

### 1. 객체의 상태를 변경하는 메서드(변경자)를 제공하지 않는다.  
### 2. 클래스를 확장할 수 없도록 한다.  
하위 클래스에서 객체의 상태를 변하게 하는 사태를 막아준다.  
```final```로 선언하는 것이 그 방법이지만, 다른 방법도 있다. (뒤에서)  
### 3. 모든 필드를 ```final```로 선언한다.  
설계자의 의도를 명확히 드러낼 수 있는 방법이다.  

### 4. 모든 필드를 ```private```으로 선언한다.  
클라이언트에서 직접 접근해 수정하는 일을 막아준다.  

### 5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.  

클래스에 가변 객체를 참조하는 필드가 하나라도 있다면 클라이언트에서 그 객체의 참조를 얻을 수 없도록 해야한다.  
**생성자, 접근자, ```readObject``` 메서드 모두에서 방어적 복사를 수행하라.**  

## 예시 1 

```
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {return re;}
    public double imaginaryPart() { return im; }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }
    ...

    @Override  
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;

        return Double.compare(c.re, re) == 0 && double.compare(c.im, im) == 0;
    }
    ...
}
```  
* 사칙연산 메서드들이 인스턴스 자신을 수정하지 않고 **새로운 Complex 인스턴스를 만들어 반환하고 있다.**  
* 이처럼 **피연산자에 함수를 적용해 그 결과를 반환하지만, 피연산자 자체는 그대로인 프로그래밍 패턴을 함수형 프로그래밍**이라 한다.  
* 메서드 이름으로 add 같은 동사 대신 ```plus```같은 전치사를 사용한 것도, **객체의 값을 변경하지 않는다는 사실을 강조하려는 의도다**  

## 불변 객체는 단순하다.  
개발자가 큰 노력을 들이지 않더라도 영원히 불변이다.  

## 불변 객체는 근본적으로 스레드 안전하여 따로 동기화 할 필요가 없다.  
여러 스레드가 동시에 사용해도 절대 훼손되지 않는다.  

## 불변객체는 안심하고 공유할 수 있다.  
불변클래스라면 한번 만든 인스턴스를 최대한 재활용하기를 권한다.  
상수로 제공하는 것이 한 방법이 될 수 있다.  

### 불변 클래스는 인스턴스를 캐싱하여 중복 생성하지 않게 해주는 정적 팩터리를 제공할 수 있다.  
새로운 클래스를 설계할 때 public 생성자 대신 정적 팩터리를 만들어두면, **클라이언트를 수정하지 않고도 필요에 따라 캐싱 기능을 덧붙힐 수 있다.**  

### 불변 객체는 방어적 복사가 필요 없다.  
불변객체를 자유롭게 공유할 수 있다는 점은 **방어적 복사도 필요 없다**는 결론으로 자연스럽게 이어진다.  
아무리 복사해봐야 원본과 같으니, 의미가 없다는 것.
```clone```과 같은 메서드는 제공하지 않는 것이 좋다.  

## 불변객체끼리는 내부 데이터를 공유할 수 있다.  

## 객체를 만들 때 다른 불변 객체들을 구성요소로 사용하면 이점이 많다.  
불변 객체느 맵의 키와 집합(Set)의 원소로 쓰기에 안성맞춤이다.  

## 불변객체는 그 자체로 실패 원자성을 제공한다.  

잠깐이라도 불일치 상태에 빠질 가능성이 없다.  

## 단점 : 값이 다르면 반드시 독립된 객체로 만들어야 한다.  

백만 비트짜리 ```BigInteger```에서 비트 하나만을 바꿔야 한다고 하면 새로운 인스턴스를 생성해야 할 것이다.  
```BitSet```도 ```BigInteger```와 같이 임의 길이의 비트 순열을 표현하지만, 가변이다. 원하는 비트 하나만 상수 시간 안에 바꿔주는 메서드를 제공한다.  

이 문제에 대처하는 방법은 2가지 이다.  

### 흔히 쓰일 다단계 연산들을 예측하여 기본 기능으로 제공한다.  

기본으로 제공한다면 각 단계마다 객체를 생성하지 않아도 된다.  

### public으로 제공한다.  

클라이언트들이 원하는 복잡한 연산을 예측하기 힘들다면, public 으로 제공하는 것이 최선이다.  
대표적인 예가 ```String```이다. (```String```의 가변 동반 클래스는 ```StringBuilder```이다.)  

## 불변 클래스 : 자신을 상속하지 못하게 하는 다른 방법  

가장 쉬운방법은 ```final``` 클래스로 선언하는 것이지만, 더 유연한 방법이 있다.  

**모든 생성자를 ```private``` 혹은 ```package-private```으로 만들고, ```public``` 정적 팩터리를 제공하는 방법이다.  

### 예시 2  
```
public Class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valudOf(double re, double im) {
        return new Complex(re, im);
    }

    ...
}

```
바깥에서 볼 수 없는 ```pakage-private``` 구현 클래스를 원하는 만큼 만들어 활용할 수 있으니 훨씬 유연하다.  

패키지 바깥의 클라이언트에서 바라본 이 불변 객체는 사실상 ```final```이다.  

```public``` 이나 ```protected``` 생서앚가 없으니 확장하는 겅시 불가능하다.  
정적 팩터리 방식은 다수의 구현 클래스를 활용한 유연성을 제공하고, 다음 릴리즈에서 객체 캐싱 기능을 추가해 성능을 끌어올릴 수도 있다.  

### ```BigInteger```와 ```BigDecimal```을 받을 때는 주의하자.  

설계 당시에 불변 객체가 **사실상** ```final```이어야 한다는 생각이 널리 퍼지지 않았다.  
그래서 이 클래스의 메서드들은 모두 재정의할 수 있게 설계되었다.  

신뢰할 수 없는 클라이언트로부터 ```BigInteger```나 ```BigDecimal```의 인스턴스를 인수로 받는다면 주의해야 한다.  

이 객체가 진짜 ```BigInteger```, ```BigDecimal``` 인지를 반드시 확인한다.  

신뢰할 수 없는 하위 클래스의 인스턴스라고 확인되면, 이 인수들은 가변이라고 가정하고 **방어적 복사** 사용해야 한다.  

```
public static BigInteger safeInstance(BigInteger val) {
    return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
}
```

## 모든 필드가 ```final```이고 수정할 수 없어야 한다. : 성능을 위해 살짝 완화해보자.  

**어떤 메서드도 객체의 상태 중 외부에 비치는 값을 변경할 수 없다.**  

어떤 불변 클래스는 계산 비용이 큰 값을 **나중에(처음 쓰일 때)** 계산하여 ```final```이 아닌 필드에 캐시해주기도 한다.  

이 방법은 **몇 번을 계산해도 항상 같은 결과가 만들어짐이 보장되기 때문이다**  

> 직렬화의 추가 주의점  
> Serializable을 구현하는 불변 클래스의 내부에 가변 객체를 참조하는 필드가 있다면 ```readObject```나 ```readResolve``` 메서드를 만드시 제공하거나, ```ObjectOutputStream.writeUnshared```와 ObjectInputStream.readUnshared``` 메서드를 사용해야 한다.  

## 정리  

**getter가 있다고 해서 무조건 setter를 만들지는 말자.**  

### 클래스는 꼭 필요한 경우가 아니면 불변이여야 한다.  

단순한 값 객체는 항상 불변으로 만들자.  

### 불변으로 만들 수 없느 클래스라도, 변경할 수 있는 부분을 최소한으로 줄이자.  

꼭 변경해야할 필드를 뺀 나머지 모두를 final로 선언하자.  

**다른 합당한 이유가 없다면 모든 필드는 private final 이어야 한다.**   

### 생성자는 불변식 설정이 모두 완료된, 초기화가 완벽히 끝난 상태의 객체를 생성해야 한다.  

확실한 이유가 없다면 생성자와 정적 팩터리 외에는 그 어떤 초기화 메서드도 public으로 제공하지 말자.  

# 아이템 34. int 상수 대신 열거 타입을 사용해라  

## 이전 정수 열거 패턴의 취약점  

```
public static final int APPLE_FUJI = 0;
public static final int ORANGE_NAVEL = 0;
```

* 타입 안전이 보장되지 않음.  
* 표현력도 좋지 않음.  
* 위 두 상수를 동등 연산자(==)로 비교하더라도 컴파일러는 경고 메시지를 출력하지 않음.  
* 정수 열거 패턴을 위한 별도의 namespace를 제공하지 않아 접두어를 써야함  
* 평범한 상수를 나열 -> 컴파일하면 그 값이 클라이언트 파일에 그대로 새겨짐 -> 상수 값이 바뀌면 다시 컴파일 해야함. -> 컴파일과 런타임 과정에서 오류를 Catch 해주지 않고, 실행은 되지만 엉뚱한 동작을 하는 코드가 되어버림  
* 출력할 때 까다로움 (디버깅을 할 때, 의미보다 단순히 값이 출력됨)  

### 열거 타입  

일정 개수의 상수 값을 정의한 다음, **그 외의 값은 허용하지 않는 타입**  

```
public enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
public enum Orange { NAVEL, TEMPLE, BLOOD }
```

**자바의 Enum은 완전한 클래스이다.**  
상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개한다.  
밖에서 접근할 수 있는 생성자를 제공하지 않는다.  
클라이언트가 인스턴스를 직접 생성하거나 확장할 수 없다.  
열거 타입 선언으로 만들어진 인스턴스들은 딱 하나씩만 존재하게 된다. = **인스턴스 통제된다.**  

> 싱긅턴은 원소가 하나뿐인 열거 타입이라고 할 수 있고, 열거 타입은 싱글턴을 일반화한 형태라고 볼 수 있다.  

#### 컴파일 타임의 타입 안전성을 제공한다.  

Apple Enum을 매개변수로 받는 메서드를 선언했다면, 해당 참조는 null이 아니라면 apple의 세가지 값 중 하나임이 확실하다.  
다른 타입의 값을 넘기려고 하면 **컴파일 오류**를 발생하게 된다.  

#### 각자의 Namespace가 있다.  
이름이 같은 상수도 평화롭게 공존한다.  
새로운 상수를 추가하거나 순서를 바꿔도 다시 컴파일 하지 않아도 된다.   
공개되는 것은 오직 필드의 이름뿐이라서, 클라이언트로 상수의 값이 각인되지 않기 때문이다.  

#### Enum의 toString() 메서드를 출력하기에 적합한 문자열을 내준다.  

#### 임의의 메서드나 필드를 추가할 수 있고, 임의의 인터페이스를 구현하게 할 수 있다.  
각 상수와 연관된 데이터를 해당 상수 자체에 내재시키고 싶을 때 사용하면 된다.  
클래스의 완전한 형태를 가지고 있으므로 가능하다.  

```
public enum Planet {
    MERCURY(3, 2),
    VENUIS(4, 6),
    EARTH(5, 6),
    MARS(6, 3),
    JUPITER(1, 7),
    SATURN(5, 6),
    URANUS(7, 2),
    NEPTUNE(1, 2)
    
    private final double mass;              //질량
    private final double radius;            //반지름  
    private final double surfaceGravity;    //표면 중력

    private static final double G = 6.6;
    
    //생성자  
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }
    public double radius() {
        return radius;
    }
    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
``` 

* 열거 타입 상수 각각을 특정 데이터와 연결지으려면 생성자에서 데이터를 받아 인스턴스 필드에 저장하면 된다.  
* 모든 필드는 final 이어야 하고, 빌드를 public 으로 선언해도 되지만 private으로 선언하고 별도의 접근자 public 메서드를 두도록 하자.  
* Planet생성자 내에서 표면 중력을 저장한 이유는 최적화를 위해서 이다. 질량과 반지름이 있으니 언제든 계산 가능하기 때문에.  

#### ```values```  

자신 안에 정의된 상수들의 값을 배열에 담아 반환하는 메서드를 제공한다.  
값들은 선언된 순서대로 저장된다.  

#### 만약 상수를 하나 제거하게 된다면?  

클라이언트 프로그램을 다시 컴파일 하면 제거된 상수를 참조하는 줄에서 컴파일 오류를 내어준다.  
컴파일 하지 않고 바로 실행하면, 런타임에서 오류를 내어준다.  

> 클라이언트에 노출해야 할 합당한 이유가 없다면 private 또는 package-private으로 선언하라.  

#### 상수마다 동작이 달라져야 하는 상황에서의 enum의 쓰임  

사칙연산 계산기의 연산 종류를 열거 타입으로 선언하고, 실제 연산까지 수행했으면 한다.  

```$xslt
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, doubkle y) {
        switch(this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DINIDE: return x / y;
        }
       throw new AssertError("알 수 없는 연산: " + this);
    }
}
```
* 동작은 하지만 switch 문을 써서 별로 좋아보이지 않는다.  
* 상수를 추가하면 case 문도 추가해줘야 하며, 깜빡할 경우 "알 수 없는 연산"이라는 Exception 런타임 에러를 낼 것이다.  
* 이를 해결하기 위해 ```apply```라는 추상 메서드를 선언하고, 상수별로 자신에 맞게 재정의 하는 방법으로 사용하자. 이를 **상수별 메서드 구현** 이라고 한다.  

```$xslt
public enum Operation {
    PLUS { public double apply(double x, double y){return x + y};
    ...

    public abstract double apply(double x, double y);
}
```
* apply 메서드가 상수 선언 바로 옆에 붙어있어, 새로운 상수를 추가할 때 빼먹기가 어려울 것이다.  
* 또한 apply 메서드는 추상 메서드이므로 재정의 하지 않았다면 컴파일 오류를 알려줄 것이다.  
* 상수별 메서드 구현과 앞에서 했던 상수별 데이터를 결합할 수도 있다.  
* 연산 로직을 Enum으로 위임하면, 연산자가 추가되더라도 외부에서 연산로직에 대한 변경은 발생하지 않는 것이 Key Point! 

```$xslt
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y){ return x + y;}
    },
    MINUS("-") {
        public double apply(double x, double y){ return x - y;}
    },
    ...

    private final String symbol;

    Operation(String symbole) {this.symbol = symbol;}

    @Override public String toString() { return symbol; }
    public abstract double apply(double x, double y);
}
```

* 내가 짠 예시
```
public enum Operator {
    ADD("+") {
        public int calculate(int firstNum, int secondNum) { return calculator.add(firstNum, secondNum); }
    },
    SUBTRACT("-") {
        public int calculate(int firstNum, int secondNum) {return calculator.subtract(firstNum, secondNum); }
    },
    MULTIPLY("*") {
        public int calculate(int firstNum, int secondNum) {return calculator.multiple(firstNum, secondNum); }
    },
    DIVISION("/") {
        public int calculate(int firstNum, int secondNum) {return calculator.divide(firstNum, secondNum); }
    };

    Calculator calculator = new Calculator();

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int calculate(int firstNum, int secondNum);
}
```
#### ```valueOf```

상수 이름을 입력받아 그 이름에 해당하는 상수를 반환해주는 메서드가 자동생성된다.  

#### fromString 구현하기  

toString이 반환하는 문자열을 해당 별거 타입 상수로 변환해주는 메소드를 제공해주면 좋을 것이다!  

```
private static final Map<String, Operation> stringToEnum = 
    Stream.of(values()).collect(
        toMAp(Object::toString, e -> e));
// 지정한 문자열에 해당하는 Operation을 (존재한다면) 반환한다.  
public static Optional<Operation> fromString(String symbol) {
    return Optional.ofNullable(stringToEnum.get(symbole));
}
```
* Operation 상수가 stringToEnum 맵에 추가되는 시점은 열거 타입 상수 생성 후, 정적 필드가 초기화 될 때이다.  
* values 메서드가 반환하는 배열 대신 스트림을 사용했다.  
* 자바 8 이전에는 빈 해시맵을 만들어 values가 반환한 배열을 순회하며 했을 것이다.  
* 하지만 열거 타입 상수는 생성자에서 자신의 인스턴스를 맵에 추가할 수 없다.  
* 열거 타입의 정적 필드 중 열거 타입의 생성자에서 접근할 수 있는 것은 상수 변수 뿐이다.  
* 열거 타입 생성자가 실행되는 시점에는 정적 필드들이 아직 초기화되기 전이라, 자기 자신을 추가하지 못하게 하는 제약이 꼭 필요하다.  
* Optional<Operation>을 반환한다. 주어진 문자열이 가리키는 연산이 존재하지 않을 수 있음을 클라이언트에 알리고, 대처하도록 한 것이다.  
* 상수별 메서드 구현은 **열거 타입 상수끼리 코드를 공유하기 어렵다는 단점이 있다.** 아래 예시를 보자.  

```$xslt
enum PayrollDay {
    MONDAY, TUESDAY, ... SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch(this) {
            case SATURDAY: case SUNDAY:
                overtimePay = basePay / 2;
                break;
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIST ? 0 : minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        
        return basePay + overtimePay;
    }
}

```
* switch문을 사용하여 간결하지만, 위험한 코드다.  
* 새로운 상수를 추가하려면 그 값을 처리하는 case문을 꼭 쌍으로 넣어줘야 하기 때문에.  
* 상수별 메서드 구현으로 이를 해결하기 위한 방법은 2가지가 있다.  
    * 잔업 수당을 계산하는 코드를 모든 상수에 중복해서 넣으면 된다.  
    * 계산 코드를 평일용과 주말용으로 나눠 각각을 도ㅓ우미 메서드로 작성한 다음 각 상수가 자신에게 필요한 메서드를 적절히 호출하면 된다.  
* 가장 깔끔한 방법은 새로운 사웃를 추가할 때 잔업수당 "전략"을 선택하도록 하는 것이다.  
* 잔업 수당 계산을 private 중첩 열거 타입으로 옮기고 PayrollDay 열거 타입의 생성자에서 이 중 적당한 것을 선택한다.  
* 그러면 PayrollDay 열거 타입은 잔업수당 계산을 그 전략 열거 타입에 위임하여 switch 문이나 상수별 메서드 구현이 필요 없게 된다.  


```
enum PayrollDay {

    MONDAY(WEEKDAY), ... , SUNDAY(WEEKEND);
    
    private final PayType payTypel
    
    PayrollDay(PayType payType) { this.payType = payType; }
    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }
    
    // 전략 열거 타입  
    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                    (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
        ...
        }
        
        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;
        
        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
        
    }
```


* switch 문은 열거 타입의 상수별 동작을 구현하는 데 적합하지 않다.  
* 하지만 기존 열거 타입에 상수별 동작을 혼합해 넣을 때는 switch 문이 좋은 선택이 될 수도 있다.  
* Operation열거타입에서 각 연산의 반대 연산을 반환하는 메서드가 필요하다고 할 때 등에서 사용하면 된다.  

### 어떨 때 사용할까?  

열거 타입의 성능은 정수 상수와 별반 다르지 않다.  
메모리에 올리는 공간과 초기화하는 시간이 더 들긴 하지만 체감될 정도는 아니다.  
**필요한 원소를 컴파일타임에 다 알 수 있는 상수 집합이라면 항상 열거 타입을 사용하자.**  
**영원히 고정 불변일 필요도 없다.**  


### 예제 1  

https://github.com/next-step/java-lotto/pull/432#discussion_r400856453 참고  

#### Refactoring 전  
```
    private static final String MATCH_FIRST_INFORMATION = "6개 일치 (2000000000원)- %s개";
    private static final String MATCH_SECOND_INFORMATION = "5개 일치, 보너스 볼 일치(30000000원)- %s개";
    private static final String MATCH_THIRD_INFORMATION = "5개 일치 (150000원)- %s개";
    private static final String MATCH_FOURTH_INFORMATION = "4개 일치 (50000원)- %s개";
    private static final String MATCH_FIFTH_INFORMATION = "3개 일치 (5000원)- %s개";
    
    ...
    
    public void showResult(LottoResult result, Money money) {
    ViewUtils.printLine(WINNING_STATISTICS_INFORMATION);
    ViewUtils.printLine(String.format(MATCH_FIFTH_INFORMATION, result.getTierCount(LottoTier.FIFTH)));
    ViewUtils.printLine(String.format(MATCH_FOURTH_INFORMATION, result.getTierCount(LottoTier.FOURTH)));
    ViewUtils.printLine(String.format(MATCH_THIRD_INFORMATION, result.getTierCount(LottoTier.THIRD)));
    ViewUtils.printLine(String.format(MATCH_SECOND_INFORMATION, result.getTierCount(LottoTier.SECOND)));
    ViewUtils.printLine(String.format(MATCH_FIRST_INFORMATION, result.getTierCount(LottoTier.FIRST)));
    
    printYield(result, money);
```

#### Enum을 이용하여 Refactoring  

```
    private static final String MATCH_RESULT_INFORMATION = "%d개 일치 (%d원)- %d개";
    
    ...

    public void showResult(LottoResult result, Money money) {
        ViewUtils.printLine(WINNING_STATISTICS_INFORMATION);

        Arrays.stream(LottoTier.values())
                .forEach(tier -> {
                    int tierCount = result.getTierCount(tier);
                    ViewUtils.printLine(String.format(MATCH_RESULT_INFORMATION, tier.getMatchedNumberCount(), tier.getPrize(), tierCount));
                });

        printYield(result, money);
    }
    
```

### Reference  

* [Enum과 가변인자](https://github.com/yeoseon/tip-archive/issues/144)  
