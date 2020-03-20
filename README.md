# int 상수 대신 열거 타입을 사용해라  

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

```

### 
### Reference  

* [Enum과 가변인자](https://github.com/yeoseon/tip-archive/issues/144)  