# HTML Input 속성 (Input Attributes)

## 기본 속성

- **type:** 입력 필드의 유형을 지정 (text, password, radio, checkbox 등)
- **name:** 폼 데이터 제출 시 사용되는 필드의 이름
- **value:** 입력 필드의 초기값
- **placeholder:** 입력 필드에 표시되는 힌트 텍스트

## 제한 관련 속성

- **required:** 필수 입력 필드 지정
- **maxlength:** 최대 입력 길이 제한
- **minlength:** 최소 입력 길이 제한
- **max:** 숫자 입력의 최대값
- **min:** 숫자 입력의 최소값

## 상태 관련 속성

- **disabled:** 입력 필드 비활성화
- **readonly:** 읽기 전용으로 설정
- **checked:** 라디오/체크박스 기본 선택 상태

## 예시 코드

```html
<!-- 텍스트 입력 -->
<input type="text" name="username" placeholder="사용자 이름" />

<!-- 비밀번호 입력 -->
<input type="password" name="pwd" required />

<!-- 체크박스 -->
<input type="checkbox" name="agree" checked />

<!-- 숫자 입력 -->
<input type="number" min="0" max="100" />
```

## 특수 속성

- **autocomplete:** 자동완성 기능 설정 (on/off)
- **autofocus:** 페이지 로드 시 자동 포커스
- **pattern:** 입력값 유효성 검사를 위한 정규식 패턴
- **step:** 숫자 입력 시 증감 단위 설정

이러한 속성들을 적절히 조합하여 사용하면 더 나은 사용자 경험과 데이터 유효성을 보장할 수 있습니다.

## autofocus와 autocomplete 사용 예시

```html
*<!-- autofocus 예시 -->
<input type="text" name="search" autofocus>

<!-- autocomplete 예시 --&gt;
<input type="email" name="email" autocomplete="on">
<input type="text" name="username" autocomplete="off">*
```

autofocus는 단순히 속성명만 추가하면 되며, 페이지가 로드될 때 해당 입력 필드에 자동으로 포커스가 됩니다.

autocomplete는 "on" 또는 "off" 값을 지정하여 자동완성 기능을 켜거나 끌 수 있습니다. 특히 이메일이나 주소 같은 자주 입력하는 정보에 유용합니다.
