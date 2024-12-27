const fs = require("fs");
const path = require("path");

// json-server, json-server-auth 불러오기
const jsonServer = require("json-server");
const auth = require("json-server-auth");

// db.json 파일 읽기
const dbFile = path.join(__dirname, "..", "db.json");
const initialData = JSON.parse(fs.readFileSync(dbFile, "utf8"));

// 서버 설정
const server = jsonServer.create();
const router = jsonServer.router(initialData);
const middlewares = jsonServer.defaults();

// json server의 db 객체를 주입
server.db = router.db;

// 기본 미들웨어 사용 (logger, static, cors 등)
server.use(middlewares);

// API 재작성 규칙 설정 - /api prefix 제거
const rewriterRules = {
  "/api/*": "/$1",
};
server.use(jsonServer.rewriter(rewriterRules));

// routes.json 파일에서 규칙 불러오기
const rules = auth.rewriter(require(path.join(__dirname, "..", "routes.json")));

// json-server-auth 규칙 설정
// const rules = auth.rewriter({
//   // users를 보호된 경로로 설정
//   users: 660,
//   // 다른 경로에 대한 규칙도 추가 가능
//   // posts: 664
// })

// auth 미들웨어 추가
server.use(rules);
server.use(auth);

// json-server 기본 라우터 사용
server.use(router);

const port = process.env.PORT || 3000;
server.listen(port, () => {
  console.log(`JSON Server is running on port ${port}`);
});

module.exports = server;
