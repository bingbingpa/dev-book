# CHAPTER 20 I/O 수행에서 데이터 전달로

- I/O와 논리가 섞인 코드를 더 단순한 부수 효과가 없는 계산으로 옮기자.
- I/O 를 프로그램 진입점으로 옮겨서 내부 처리를 동작이 아닌 연산으로 만들 수 있고, 내부 처리가 더 이상 I/O 를 책임지지 않아도 된다.
- Sequence 를 이터레이션하는 것이 List 를 이터레이션 하는 것과 비슷해 보이지만, Sequence 의 내용을 소비하면서 Sequence 자체가 변경될 수도 있다.
- 한 번에 모든 줄을 다 읽고 Sequence 로 바꾸는 대신, Reader 에서 buffered().lineSequence() 를 통해 Sequence 를 얻으면 메모리를 절약할 수 있다.