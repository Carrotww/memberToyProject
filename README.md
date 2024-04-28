# 더커머스 토이 프로젝트 - 유형석

# 프로젝트 환경
- jdk 1.8
- spring boot 2.6.2
- Gradle

# 설치 방법
## 필수 조건
- jdk1.8 설치
- git 설치

## 설치
1. 빈 파일 생성 후 프로젝트 클론
```bash
git clone https://github.com/Carrotww/memberToyProject.git
cd memberToyProject
```
2. 프로젝트 빌드
```bash
./gradlew build
```

3. 프로젝트 실행
```bash
java -jar build/libs/toy-0.0.1-SNAPSHOT-plain.jar1-SNAPSHOT.jar
```

# API 문서
## Swagger 사용 url - API Sheet
- 이 프로젝트의 API문서는 Swagger를 통해 제공됩니다. 프로젝트를 실행 후 아래 url로 접속해주세요.
  http://localhost:8080/swagger-ui/index.html

# 폴더 구조 설명
1. 공통된 기능을 위한 global 폴더를 둔 후 member 도메인에 관련된 기능들을 추가하기 위해 member 폴더에 member 관련 기능을 넣었습니다.
2. global 에 공통된 응답을 위한 ApiResponse dto Error Handling을 위한 GlobalExceptionHandler를 추가하였으며 password encoding을 위해 spring security를 추가했습니다.
3. member 폴더에 member entity, controller, service, dto, repository 폴더로 구성하였습니다.

# 데이터 모델 설계
1. member entity
  - id : 데이터베이스 기본 키
  - memberLoginId : 로그인을 위한 member id
  - password : 로그인을 위한 비밀번호
  - nickname : Member 닉네임
  - phoneNumber : 전화번호
  - email : email
2. basemodel entity
  - createdAt : 생성 시간
  - lastModifiedAt : 수정 시간

# 모의 데이터 추가
- /src/main/resources/data.sql 경로에 h2 데이터베이스용 모의 user 객체 추가