# Items  

* [아이템 01. 생성자 대신 정적 팩터리 메서드를 고려하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-01-%EC%83%9D%EC%84%B1%EC%9E%90-%EB%8C%80%EC%8B%A0-%EC%A0%95%EC%A0%81-%ED%8C%A9%ED%84%B0%EB%A6%AC-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EA%B3%A0%EB%A0%A4%ED%95%98%EB%9D%BC)  
* [아이템 02. 생성자에 매개변수가 많다면 빌더를 고려하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-02-%EC%83%9D%EC%84%B1%EC%9E%90%EC%97%90-%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98%EA%B0%80-%EB%A7%8E%EB%8B%A4%EB%A9%B4-%EB%B9%8C%EB%8D%94%EB%A5%BC-%EA%B3%A0%EB%A0%A4%ED%95%98%EB%9D%BC)
* [아이템 03. private 생성자나 열거 타입으로 싱글턴임을 보장하라.](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-03-private-%EC%83%9D%EC%84%B1%EC%9E%90%EB%82%98-%EC%97%B4%EA%B1%B0-%ED%83%80%EC%9E%85%EC%9C%BC%EB%A1%9C-%EC%8B%B1%EA%B8%80%ED%84%B4%EC%9E%84%EC%9D%84-%EB%B3%B4%EC%9E%A5%ED%95%98%EB%9D%BC)  
* [아이템 04. 인스턴스화를 막으려거든 private 생성자를 사용하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-04-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%ED%99%94%EB%A5%BC-%EB%A7%89%EC%9C%BC%EB%A0%A4%EA%B1%B0%EB%93%A0-private-%EC%83%9D%EC%84%B1%EC%9E%90%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%9D%BC)  
* [아이템 05. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-05-%EC%9E%90%EC%9B%90%EC%9D%84-%EC%A7%81%EC%A0%91-%EB%AA%85%EC%8B%9C%ED%95%98%EC%A7%80-%EB%A7%90%EA%B3%A0-%EC%9D%98%EC%A1%B4-%EA%B0%9D%EC%B2%B4-%EC%A3%BC%EC%9E%85%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%9D%BC)
* [아이템 06. 불필요한 객체 생성을 피하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-06-%EB%B6%88%ED%95%84%EC%9A%94%ED%95%9C-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%9D%84-%ED%94%BC%ED%95%98%EB%9D%BC)  
* [아이템 07. 다 쓴 객체 참조를 해제하라]()  
* [아이템 14. Comparable 구현을 고려하라](https://github.com/yeoseon/effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-14-comparable-%EA%B5%AC%ED%98%84%EC%9D%84-%EA%B3%A0%EB%A0%A4%ED%95%98%EB%9D%BC)  
* [아이템 17. 변경 가능성을 최소화하라.](https://github.com/yeoseon/book__effective-java/blob/master/README.md#%EC%95%84%EC%9D%B4%ED%85%9C-17-%EB%B3%80%EA%B2%BD-%EA%B0%80%EB%8A%A5%EC%84%B1%EC%9D%84-%EC%B5%9C%EC%86%8C%ED%99%94%ED%95%98%EB%9D%BC)  
* [아이템 34. int 상수 대신 열거 타입을 사용해라](https://github.com/yeoseon/effective-java#int-%EC%83%81%EC%88%98-%EB%8C%80%EC%8B%A0-%EC%97%B4%EA%B1%B0-%ED%83%80%EC%9E%85%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%9D%BC)  
* [아이템 50. 적시에 방어적 복사본을 만들라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-50%EC%A0%81%EC%8B%9C%EC%97%90-%EB%B0%A9%EC%96%B4%EC%A0%81-%EB%B3%B5%EC%82%AC%EB%B3%B8%EC%9D%84-%EB%A7%8C%EB%93%A4%EB%9D%BC)  
* [아이템 72. 표준 예외를 사용하라](https://github.com/yeoseon/book__effective-java#%EC%95%84%EC%9D%B4%ED%85%9C-72-%ED%91%9C%EC%A4%80-%EC%98%88%EC%99%B8%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%9D%BC) 

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

# 아이템 02. 생성자에 매개변수가 많다면 빌더를 고려하라.  

**객체의 선택적 매개변수가 많을 때, 빌더패턴을 이용하여 생성자를 만들자.**  

## 기존 매개변수가 많을 때 해결 방법 : 점층적 생성자 패턴과 자바빈즈 패턴  

### 점층적 생성자 패턴  
* 필수 매개변수만 받는 생성자, 필수 + 선택1, 필수 + 선택 2 ...

#### 단점  
* 클라이언트 코드를 작성하거나 읽기 어렵다.  
* 각 값의 의미가 무엇인지 헷갈린다.  
* 매개변수를 실수로 잘못 넣어도, 런타임때 되서야 오류를 발견할 수 있다.  

### 자바빈즈 패턴  
* 매개변수가 없는 생성자로 만든 후 Setter 메서드를 호출해 값을 설정하는 방식  
```aidl
public class Sample {
    private int a = -1; // 필수 : 기본값 없음
    private int b = -1; // 필수 : 기본값 없음
    private int c = 0; //선택값
    private int d = 0;
    
    public Sample() {}
    
    public void setA(int a) {
        thia.a = a;
    }
    ... //Setter 들 
}
```

#### 단점  
* Setter를 사용한다는 것 자체는 불변식을 깨지게 하기 때문에 매우 좋지 않다.  
* 객체 하나를 만드려면 메서드를 여러개 호출해야 한다.  
* 객체 하나가 완전히 생성되기 전까지는 일관성이 무너진 상태이다.  
* Setter를 public으로 공개하고 있기 때문에 절대 불변 객체로 만들 수 없다.  

## 빌더 패턴을 사용하여 해결하자!

* 클라이언트는 필수 매개변수만으로 생성자 혹은 정적 팩터리를 호출해 빌더 객체를 얻는다. 
* ㅇ빌더 객체가 제공하는 일종의 Setter 메서드로 원하는 선택 매개변수를 설정한다.  
* 마지막으로 매개변수가 없는 build 메소드를 호출하여 객체를 얻는다.  

### 예시  

```
public class Sample {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    
    public static class Builder {
        //필수 매개 변수  
        private final int a;
        private final int b;
        
        //선택 매개변수는 초기화한다.
        private int c = 0;
        private int d = 0;
        private int e = 0;
        
        public Builder(int a, int b) {
            // 여기서 입력 매개변수를 첫번째로 유효성 검사하는 것이 좋다.  
            this.a = a;
            this.b = b;
        }
        
        public Builder c(int val) {
            c = val;
            return this;
        }
        
        public Builder d(int val) {
            d = val;
            return this;
        }
        
        public Builder e(int val) {
            e = val;
            return this;
        }
        
        public Sample build() {
            return new Sample(this);
        }
    }
    
    private Sample(Builder builder) {
        // 여기서 매개변수 불변식 검사를 한번 더 해주는 것이 좋다.  
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
        e = builder.e;
    }
}
```

* Sample 클래스는  불변이다.  
* 빌더의 Setter 메서드는 모두 Builder 자신을 반환하기 때문에, 연쇄적으로 호출 가능하다.  
    ```
    Sample sample = new Sample.Builder(1, 2)
                              .c(3).d(4).e(5).build();
    ```  
* 매개변수를 검사할 때는 Builder 생성자 내부에서 한번 검사하고, Sample 생성자 내부에서 한번 더 불변을 검사하자.  

### 단점  
* 빌더 생성 비용이 크지는 않지만, 객체 하나를 작성하려면 Builder도 같이 작성해주어야 한다.  
* 객체 만들기 위해 빌더 객체도 만들어 주어야 하므로 성능에 민감한 상황에서는 비용이 크지 않더라도 문제가 될 수 있다.  
* 코드가 장황해서 매개변수가 4개 이상인 경우에 값어치를 한다.  
  
# 아이템 03. private 생성자나 열거 타입으로 싱글턴임을 보장하라.  

## 싱글턴의 예시  
* 무상태 객체
* 유일해야 하는 시스템 객체  
* ... 

## 싱글턴으로 만드는 방법 1  
```aidl
public class Sample {
    public static final Sample INSTANCE = new Sample();
    private Sample() {...}
}
```
* public static 멤버를 final로 둔다.  
* private 생성자는 Sample.INSTANCE를 초기화할 때 딱 한번만 호출된다.  
* 리플렉션 API(AccessibleObject.setAccessible)을 사용해 권한이 있다면 private 생성자를 호출할 수 있는 예외는 있다.  
    * 이를 방어하기 위해, 생성자에 2번째 객체가 생기려 할 때 예외를 던지도록 처리해준다.  
### 장점  
* 해당 클래스가 싱글턴임이 API를 보고 명백히 알 수 있다.  
* 간결하다.  

## 싱글턴으로 만드는 방법 2  
```aidl
public class Sample {
    private static final Sample INSTANCE = new Sample();
    private Sample() { ... }
    public static Sample getInstance(){ return INSTANCE;}
}
```
* 정적팩터리 메서드를 public static으로 제공한다.  
* 첫번째 방법에서 발생하는 예외는 역시 발생한다. 

### 장점  
* 싱글턴이 아니게 바꾸고 싶다면, API를 바꾸지 않고도 변경할 수 있다.   
    * 스레드별로 다른 인스턴스를 넘겨주게 처리할 수 있다.  
* 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다. (아이템 30 참고)  
* 정적 팩터리의 메서드 참조를 공급자로 사용할 수 있다.  
-> 이 장점이 필요하지 않다면 1번 방법을 사용하자.  

**1번과 2번 방식은 직렬화된 인스턴스를 역직렬화 할 때, 새로운 인스턴스가 만들어진다.**  
**이를 방지하기 위해 readResolve 메서드를 구현해주어야 한다.**  

## 싱글턴으로 만드는 방법 3 : 열거 타입(enum) 이용  

```aidl
public enum Sample {
    INSTANCE;
}
```
* public 필드 방식과 비슷하지만, 더 간결하고 추가 노력 없이 직렬화 할 수 있다.  
* 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도 제 2의 인스턴스가 절대 생기지 않는다.  
* 대부분의 상황에서는 원소가 하나뿐인 열거타입이 싱글턴을 만드는 가장 좋은 방법이다.  
* 단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 사용할 수 없다.  

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
    * 모든 생성자는 무조건 상위 클래스의 생성자를 호출하게 되므로 private으로 선언되어 있으면 호출하지 못하여 상속이 불가능 하다.  

# 아이템 05. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라  

## 잘못된 예 : 정적 유틸리티 
```
public class SpellChecker {
    private static final Lexicon dictionary = ...;
    
    private SpellChecker() {}   //객체 생성 방지 
    
    public static boolean isValie(...){....}
    public static ...
}
```

* 외부 의존성이 있는데 (Lexicon): 이를 정적으로 구현함  

## 잘못된 예 : 싱글턴 사용  
```aidl
public class SpellChecker {
    private final Lexicon dictionary = ...;
    
    private SpecllCheck(...){}
    public static SpellChecker INSTANCE = new SpellChecker(...);
    
    public boolean isValie(...){...}
    public ...
}
```
* 외부 의존성이 있는데 싱글턴으로 구현함

**두 방식 모두 사전을 단 하나만 사용한다고 가정한다는 점에서 훌륭하지 않다.**  
**사전이 언어별로 따로 있고, 특수 어휘용 사전을 별도로 두기도 한다면..**  

## SpellChecker가 여러 사전을 사용할 수 있도록  

* final 한정자를 제거하고, 다른 사전으로 교체하는 메소드를 두는 방식도 좋지만, 멀티쓰레드 환경에서는 쓸 수 없다.  
* 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티나 싱글턴이 적합하지 않다.  
* 클라이언트가 원하는 자원을 사용해야 한다.  

```aidl
public class SpellChecker {
    private final Lexicon dictionary;
    
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Object.requireNonNull(dictionary);    
    }
    ...
}
```  
* 인스턴스를 생성할 때, 생성자에 필요한 자원을 넘겨쥬는 방식  
* 생성자, 정적팩터리, 빌더 모두에 똑같이 응용할 수 있다.  
* 생성자에 자원 팩터리를 넘겨주는 방식  
    * 호출할 때마다, 특정 타입의 인스턴스를 반복해서 만들어주는 객체 
    * Supplier<T>를 이용해 자신이 명시한 타입의 하위 타입이라면 무엇이든 생성할 수 있는 팩터리를 넘길 수 있다.  
* 의존성이 많아지면 관리하기 골치아프다. 그래서 Spring Framework 같은 의존성 관리 기능을 가진 프레임워크를 사용하는 것  

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

# 아이템 07. 다 쓴 객체 참조를 해제하라  

Java는 가비지 컬렉션을 지원하기에, 메모리 관리가 타 언어보다는 쉽지만 아예 신경을 안써도 되는 것은 아니다.  

다 쓴 객체에 대한 참조를 해제하지 않으면 가비지 컬렉션의 대상이 되지 않아, 메모리 누수 현상이 일어날 수 있다.  

## 가비지컬렉션의 대상이 되기 위한 조건  

### 1. 직접 할당을 해제한다.  

* 객체 참조 변수를 null로 초기화하는 방법이다.  
* 어떠한 참조도 가지지 않기 때문에, 가비지 컬렉션의 대상이 된다.  
* 소스코드가 지저분해질 우려가 있어 바람직한 방법은 아니기에 예외적인 경우에만 사용하는 것이 좋다.  
* 클래스 내에서 메모리를 직접 관리하는 객체라면 이 방법을 통해 관리하는 것이 좋다.  

### 2. Scope 밖으로 밀어내기  

* 가장 좋은 방법이다.  
* 변수의 범위를 최소가 되게 정의했다면, 이 일은 자연스럽게 이루어 진다.  

## 메모리 누수를 일으키는 주범  

### 1. 위에서 설명한 class 내에서 참조를 직접 관리하는 객체 (ex. 스택)  
### 2. Map과 같은 캐시  

Map과 같은 캐시에 객체 참조를 넣어두고, 초기화를 안시켜주는 경우 메모리 누수가 발생한다.  
엔트리가 살아있는 동안만 캐시를 사용하려면 WeakHashMap을 사용한다. 단, 이 경우에만 사용한다.  

### Java Reference  

1. Strong Reference  
    * 우리가 흔히 사용하는 Reference  
    * String str = new String("abc")와 같은 형태이다.  
    * GC의 대상이 되지 않는다.  
    * null 초기화 방법으로 해제 해주어야 한다.  
2. Soft Reference  
    * SoftReference<Class> ref = new SoftReference<>(new String("abc")); 와 같은 형태로 사용  
    * 대부분 GC의 대상이 아니지만, out of memory 에러가 날 위험이 있을 경우 GC 대상이 된다.  
3. Weak Reference  
    * WeakReference<Class> ref = new WeakReference<Class>(new String("abc")); 와 같은 형태로 사용된다.  
    * 항상 GC의 대상이 된다.  
4. Phantomly Reference  
    * finalize 되었지만, 메모리가 아직 회수되지 않은 객체  
   
### WeakHashMap 예제  

```aidl
public class ClassWeakHashMap {
    public static class Referred {
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }

    /**
    * GC를 발생 시켜 메모리를 회수하는 코드
    * System.gc()가 잘 동작할지는 모르겠다.
    */
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(5000);
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Creating weak references");

        // This is now a weak reference. 
        // The object will be collected only if no strong references. 
        Referred strong = new Referred(); //Strong Reference로 하나 추가

        //Weak Reference를 이용한 WeakHashMap에 엔트리를 추가하여
        //Weak Reference 추가
        Map<Referred, String> metadata = new WeakHashMap<Referred, String>();
        metadata.put(strong, "WeakHashMap's make my world go around");

        // Attempt to claim a suggested reference. 
        ClassWeakHashMap.collect();
        //여기서는 gc가 발생해도 GC대상이 아니게 된다.
        //strong이라는 변수를 통해 Strong Reference를 가지므로 GC 대상이 아니다.
        System.out.println("Still has metadata entry? " + (metadata.size() == 1));
        System.out.println("Removing reference");

        // The object may be collected. 
        //Strong Reference를 끊었다.
        strong = null;

        //여기서는 Weak Reference만 남아 있기 때문에 GC대상이 된다.
        ClassWeakHashMap.collect();
        System.out.println("Still has metadata entry? " + (metadata.size() == 1));
        System.out.println("Done");
    }
}
```  

### 3. 리스너 또는 콜백  

* root set에 대한 직접 참조가 아닌 객체에서의 참조를 가지고 있다.  
* weak reference를 이용해 리스너와 콜백을 사용하는 것이 좋다.  




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

# 아이템 50.적시에 방어적 복사본을 만들라.  

## Java는 안전한 언어이다.  

버퍼오버런, 배열 오버런, 와일드 포인터 같은 메모리 출동 오류에서 안전하다.  
자바로 작성한 클래스는 시스템의 다른 부분에서 무슨 짓을 하든 그 불변식이 지켜진다.  

## 클라이언트가 불변식을 ㄲ뜨리려 혈안이 되어있다고 가정하고 방어적으로 프로그래밍 하자.  

아무리 자바라고 해도, 다른 크래스로부터의 침범을 아무런 노력 없이 다 막을 수 있지는 않다.  
평범한 프로그래머도 순ㅅ전히 실수로 클래스를 오작동하게 만들 수도 있다.  


```
public final class Period {
    private final Date start;
    private final Date end;  

    public Peroid(Date start, Date end) {
        if(start.compareTo(end) > 0) {
            throw new IllegalArgumentException ();    
        }
        this.start = start;
        this.end = end;  
    }
    public Date start() {
        return start;
    }
    public Date end() {
        return end;
    }
    ...
}
```

* Date 객체는 가변 객체라는 사실을 이용하여 언제든 불변식을 깨뜨릴 수 있다.  
```
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end);
end.setYear(78);    // p의 내부를 수정했다.
```
> 자바 8 이후로는 Date는 더이상 사용하면 안된다.  
> Date 대신 Instant(혹은 LocalDateTime이나 ZoneDateTime)을 사용하라.
> 하지만 Date를 사용하던 시절이 워낙 길었기 때문에, 기존 코드에서는 호환성을 위해 어쩔 수 없이 사용할 수 밖에 없다.  

## 생성자에서 받은 가변 매개변수 각각을 방어적으로 복사(Defensive Copy) 하자.  

**Period 인스턴스 내부에서는 원본이 아닌 복사본을 사용해야 한다.  

```
public Period(Date start, Date end) {
    this.start = new Date(start.getTime()); // 새롭게 인스턴스를 생성하였다.
    this.end = new Date(end.getTime());

    if(this.start.compareTo(this.end) > 0) {
        throw new IllegalArgumentException();
    }
}
``` 
* 다음과 같이 새로 작성한 생성자를 사용하면 위협이 되지 않는다.  
* **매개변수의 유효성을 검사하기 전에, 방어적 복사본을 만들고, 이 복사본으로 유효성을 검사한 점에 주목하자.**  
    * 멀티스레딩 환경이라면, 유효성을 검사한 후 복사본을 만드는 그 찰나의 취약한 순간에 다른 스레드가 원본 객체를 수정할 윌험이 있기 때문이다.  
    * 이런 검사/사용시점 공격을 TOCTOU 공격이라고 한다.  

## 매개변수가 제 3자에 의해 확장될 수 있는 타입이라면 방어적 복사본을 만들 때 clone을 사용해서는 안된다.  

위의 예를 다시 보자.  

* **방어적 복사의 clone 메서드를 사용하지 않는 점에도 주목하자.**
    * Date는 final이 아니므로, clone이 Date가 정의한게 아닐 수도 있다.  
    * clone이 악의를 가진 하위 클래스의 인스턴스를 반환할 수도 있다.  

## Period 인스턴스는 아직도 변경이 가능하다. : 접근자로 가변 필드의 방어적 복사본을 반환해야 한다.  

생성자를 수정하면 앞서의 공격은 막을 수 있지만, 접근자 메서드가 내부의 가변 정보를 직접 드러내기 때문에 아직도 변경이 가능하다.   
```
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end);
p.end().setYear(78);    // p의 내부를 또 변경했다.  
```

이를 해결하려면 다음과 같이 접근자가 가변필드의 방어적 복사본을 반환해야 한다.  

```
public Date start() {
    return new Date(start.getTime());
}
```

## 생성자와는 달리 접근자 메서드에서는 clone을 사용해도 된다.  

Period가 가지고 있는 Date 객체는 java.util.Date임이 확실하기 때문이다.  
**그렇더라도 인스턴스를 복사하는 데는 일반적으로 생성자나 정적 팩터리를 쓰는게 좋다.**  

## 방어적 복사는 불변객체를 만들기 위해서만 사용하지는 않는다.  

### 메서드든 생성자든 클라이언트가 제공한 객체의 참조를 내부 자료구조에 보관해야 할 때면 항시 그 객체가 잠재적으로 변경될 수 있는지는 생각해야 한다.  

변경될 수 있는 객체라면, **그 객체가 클래스에 넘겨진 뒤 임의로 변경되어도, 그 클래스가 문제없이 동작할 지를 따져보자.**  
**확신할 수 없다면 복사본을 만들어 저장해야 한다.**  

(예) 클라이언트가 건내준 객체를 Set 인스턴스에 저장하거나, Map 인스턴스의 키로 사용한다면 추후 임의로 변경될 경우 불변식이 깨질 것이다.  

### 내부 객체를 클라이언트에 껀네주기 전에 방어적 복사본을 만드는 이유도 마찬가지다.  

클래스가 불변이든 가변이든, 가변인 내부 객체를 클라이언트에 반환할 때는 반드시 심사숙고해야한다.  
길이가 1 이상인 배열은 무조건 가변임을 잊지 말자.   
그러니 내부에서 사용하는 배열을 클라이언트에 반환할 때에는 항상 방어적 복사를 수행해야 한다.  
혹은 배열의 불변 뷰를 반환하는 대안도 있다.  

## 방어적 복사에는 성능 저하가 따르고, 항상 사용할 수 있는 것도 아니다.  

복사 비용이 너무 크거나, 클라이언트가 그 요소를 잘못 수정할 일이 없음을 신뢰한 다면 생략해도 좋다.  
하지만 문서화 하자.  

호출자가 컴포넌트 내부를 수정하지 않으리라 확신하면, 방어적 복사를 생략할 수 있다.  
이러한 상황일여도, 수정하지 말아야 함을 명확히 **문서화**하는 것이 좋다.  

다른 패키지에서 사용한다고 해서 항상 방어적 복사를 사용해야하는 것은 아니다.  
때로는 매개변수로 넘기는 행위가 통제권을 이전함을 뜻하기도 한다.  
이처럼 통제권을 이전하는 메서드를 호출하는 클라이언트는 해당 객체를 더이상 직접 수정하는 일이 없다고 약속해야 한다.  
이 사실 또한 문서화해야 한다.  

통제권을 넘겨받기로 한 메서드나 생성자를 가진 클래스들은 공격에 취약하다.  

1. 클라이언트가 상호 신뢰할 수 있을 때,  
2. 불변식이 깨지더라도 그 영향이 오직 호출한 클라이언트로 국한될 때  

이 상황에서만 방어적 복사를 생략할 수 있다.  

# 아이템 72. 표준 예외를 사용하라.  

자바 라이브러리는 대부분 API에서 쓰기에 충분한 수의 예외를 제공한다.  

## 표준 예외를 재사용할 경우의 장점  

* 다른 사람이 익히고 사용하기 쉬워진다.  
* 내가 만든 API를 사용한 프로그램 역시 읽기 쉽게 된다.  
* 예외 클래스 수가 적을 수록 메모리 사용량도 줄고 클래스를 적재하는 시간도 적게 걸린다.  

## 많이 사용되는 예외  

### ```IllegalArgumentException```  

호출자가 인수로 부적절한 값을 넘길 때 던지는 예외.  
(예) 반복 횟수를 지정하는 매개 변수에 음수를 건낼 때  

### ```IllegalStateException```  

대상 객체의 상태가 호출된 메서드를 수행하기에 적합하지 않을 때 던지는 예외.  
(예) 초기화되지 않은 객체를 사용하려 할 때  

### ```ConcurrentModificationException```  

단일 스레드에서 사용하려고 설계한 객체를 여러 스레드가 동시에 수정하려 할 때 던지는 예외.
동시 수정을 검출할 수 있는 방법이 없으니, 문제가 생길 가능성을 알려주는 정도의 용도로 쓰인다.  

### ```UnsupportedOperationException```  

클라이언트가 요청한 동작을 대상 객체가 지원하지 않을 때 던지를 예외.  
대부분 객체는 자신이 정의한 메서드를 모두 지우너하므로, 흔히 쓰이는 예외는 아니다.  
보통 구현하려는 인터페이스의 메서드 일부를 구현할 수 없을 때 사용한다.  
(예) 원소를 넣을 수만 잇는 ```List``` 구현체에 대고 ```remove```를 호출할 때  

## 특수한 경우

뭉뚱 그려 ```IllegalArgumentException``` 이나 ```IllegalStateException```으로 던질 수 있지만,  
특수한 일부는 따로 구분해 사용한다.  

### ```NullPointerException```  

관례상 메서드에 ```null```을 허용하지 않는데 건낸 경우 ```NullPointerException```을 던진다.  

### ```IndexOutOfBoundsException```  

어떤 시퀀스의 허용 범위를 넘는 값을 건낼 때  

## ```Exception```, ```RuntimeException```, ```Throwable```, ```Error```는 직접 재사용하지 말자.  

추상 클래스라고 여기자.  
다른 예외들의 상위 클래스이므로, 안정적으로 테스트할 수 없다.  

## 상황에 부합한다면 항상 표준 예외를 재사용하자.  

위의 흔히 쓰이는 예 말고도 상황이 부합한다면 꼭 재사용하자.  
(예) 복소수나 유리수를 다루는 객체를 작성하는 경우 ```ArithmeticException```이나 ```NumberFormatException```을 재사용할 수 있다.  

이 때 **API 문서를 참고해 그 예외가 어떤 상황에서 던져지는지 꼭 확인해야 한다.**  
예외의 이름뿐만 아니라 예외가 던져지는 맥락도 부합할 때만 사용한다.  

## 표준 예외를 확장해도 좋다. 단..  

단 예외는 직렬화할 수 있다는 사실을 기억하자.  
직렬화에는 많은 부담이 따르니, 이 사실만으로도 나만의 예외를 새로 만들지 않는 방향으로 가는 것이 좋을 것이다.

## ```IllegalArgumentException``` vs ```IllegalStateException``` ?  

(예) 카드 덱을 표현하는 객체가 있고, 인수로 건낸 수 만큼의 카드를 뽑아 나눠주는 메서드를 제공한다고 하자.  
이 때 덱에 남아 있는 카드 수보다 큰 값을 건넬 경우 어떤 예외를 던질까?  

**인수의 값이 너무 크다고 본다면 ```IllegalArgumentException```을,  
덱에 남은 카드 수가 너무 적다고 본다면 ```IllegalStateException```을 선택한다.**  

**인수의 값이 무엇이었든 어차피 실패할 경우 ```IllegalStateException```,  
그렇지 않으면 ```IllegalArgumentException```을 사용한다.**  
