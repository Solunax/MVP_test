# MVP_test
MVP 패턴 학습을 위한 간단한 앱

- Edit Text 2개로 이름, 이메일을 입력받고 SharedPreference로 저장 및 2개의 Text View에 각각의 정보를 출력하는 간단한 동작 수행하는 앱

## MVP?
- 디자인 패턴중 한가지로 View와 Model이 Presenter를 통해 동작함
- View는 Model을 직접 호출할 수 없고, Model은 View에 직접 데이터를 전달할 수 없음
- Model, View, Presenter의 역할은 다음과 같음
    - Model : 데이터와 비즈니스 로직
    - View : View에 대한 접근
    - Presenter : View와 Model 사이에서 데이터 전달

## 적용
- Contractor라는 인터페이스를 생성해 View, Presenter의 역할을 정의
- 생성한 인터페이스는 각각 View와 Presenter에서 구현하여 사용함
- Model은 Repository 패턴을 적용(구글의 Architecture Sample)
    - Repository 패턴은 데이터 레이어를 앱의 나머지 부분에서 분리하는 디자인 패턴
    - Repository는 싱글톤 패턴으로 생성함
        - 하지만 이 앱에선 간단한 기능만 구현하기 때문에 싱글톤으로 작성하진 않음
    - SharedPreference(내부 저장소)를 사용하기 때문에 이를 Repository에 정의함
- 구조<br>
    - 초기에 SharedPreference에 저장된 값을 불러옴
        - 있으면 View에 출력, 없으면 초기 상태 그대로
    - View에서 데이터 입력 후 버튼 클릭시
        - 데이터를 Presenter로 전달
        - Presenter는 View에서 넘어온 정보를 Model로 전달
        - Model은 Presenter에서 넘어온 데이터를 Local에 저장함(SharedPreference)
        - View 데이터의 갱신은 Presenter로 데이터 전달 시 View 갱신 메소드를 같이 실행되게함
    
