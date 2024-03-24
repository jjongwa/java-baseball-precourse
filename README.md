# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - [예] 상대방(컴퓨터)의 수가 425일 때, 
    - 123을 제시한 경우: 1스트라이크, 
    - 456을 제시한 경우: 1스트라이크 1볼, 
    - 789를 제시한 경우: 낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다. 
- 사용자가 잘못된 값을 입력할 경우 `[ERROR]`로 시작하는 에러 메시지를 출력하고 게임을 계속 진행할 수 있어야 한다.

## 프로그램 실행 결과
```
숫자를 입력해주세요 : 123
1스트라이크 1볼 
숫자를 입력해주세요 : 145
1볼 
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 끝
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
…
```

## 프로그래밍 요구사항
### 제약사항
- **자바 코드 컨벤션을 지키면서 프로그래밍**한다.
  -https://naver.github.io/hackday-conventions-java/
- **indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용**한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- **자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.**
- **else 예약어를 쓰지 않는다.**
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
### 단위 테스트
- **도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외**
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 힌트는 MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중한다.
- JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현한다.

## ⚾️ 구현할 기능 목록 🥎
### 투구(PitchBalls)
- [x] 하나의 투구는 서로 다른 3개의 숫자를 가지고 있다.
  - 숫자의 범위는 1 이상 9 이하이다.
  - 각 숫자들엔 순서가 존재한다.
- [x] 다른 투구와 비교하여 기록(Score)을 반환할 수 있다.
  - 각 숫자의 값과 순서가 모두 같으면 스트라이크(strike), 값은 같지만 순서가 다르면 볼(ball)에 해당한다.

### 기록(Score)
- [x] 기록은 스트라이크(strike)와 볼(ball)로 구분된다.
- [x] 스트라이크와 볼은 각각 0에서 3 사이의 자연수이다.

### 게임(Game)
- [ ] 각 게임은 정답(answer)에 해당하는 투구(PitchBalls)를 1개 가지고 있다.
  - 정답은 게임이 시작될 때 랜덤으로 만들어 진다.
- [ ] 게임은 새로운 투구를 받아 정답과 비교한 후 기록(Score)을 반환할 수 있다.
  - 정답(answer)과 새로운 투구(newPitch)가 가지고 있는 숫자들을 비교해 기록(Score)을 생성한다. 
