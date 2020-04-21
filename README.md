# 아이템 14. Comparable 구현을 고려하라  

> LottoNumber 가 Comparable 을 구현하였는데 getValue() 로 값을 꺼내올 필요가 있을까요? (https://github.com/next-step/java-lotto/pull/404#discussion_r399871346 참고)  

Comparable을 구현했다는 것은 equals, hashCode 등을 오버라이딩하여 재구현했다는 말.  
따라서 getValue를 통해 실제 값을 가져와 비교해줄 필요가 없다.  

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
