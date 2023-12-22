package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;
//	while switch 문의 종료 명령어를 받으면 switch 문에서 빠져나와야 함으로 byte type 의 system_status 변수에 1의 값을 넣어줌
	public App() {
//	App 설계도 
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
// run 의 설계도 void 로 return 값 x == 명언 앱 실행 == 출력 		
		SystemController systemController = new SystemController(); // SystemController type 을 연결할 수 있는 systemController 변수에 새로운 객체 SystemController을 만들어서 연결
		WiseSayingController wiseSayingController = new WiseSayingController();// WiseSayingController type 을 연결할 수 있는 wiseSayingController 변수에 새로운 객체 WiseSayingController을 만들어서 연결

		while (system_status == 1) { // while 반복문으로 system_status == 1로 참일 때 위에 system_status 변수에 정수 1을 넣었기 때문에 무한루프 진행
			System.out.print("명령어 ) "); // while 문이 참일 때 "명령어 ) 출력 
			String cmd = Container.getScanner().nextLine().trim(); // Container class 에 있는 Scanner 리모컨을 출력 Scanner 입력 값을 String type 만을 넣을 수 있는 변수 cmd 에 저장
			Rq rq = new Rq(cmd); // Rq type 만을 연결할 수 있는 변수 rq 에 새로운 객체 Rq를 만들고 그 안에 cmd 값 저장 Rq class 에 parsing 요청

			switch (rq.getActionCode()) { //switch 문 rq. getActionCode의 결과 값으로 조건에 맞는 case로 진행 
			case "종료":
				systemController.exit(); // getActionCode 가 "종료" 일 경우 ststemController 의 exit 메소드 실행 == 명언 앱 종료 출력 ==
				system_status = 0; // system_status 값을 0으로 초기화 시키고 break 로 switch 문 빠져나옴 while 문의 system_status !== 1 이므로 false while 문 빠져나옴 
				break;
			case "등록": // ActionCode가 "등록" 일 case
				wiseSayingController.write(); // wiseSayingController class 의 write 함수 실행
				break; // break 만나 switch 문 빠져나옴 다시 while 문으로 돌아가서 true 이기 때문에 다시 while 문 진행
			case "목록": // ActionCode가 "목록" 일 case
				wiseSayingController.list(); // wiseSayingController class 의 list 함수 실행
				break;	// break 만나 switch 문 빠져나옴 다시 while 문으로 돌아가서 true 이기 때문에 다시 while 문 진행
			case "삭제":	// ActionCode가 "삭제" 일 case
				wiseSayingController.remove(rq); // wiseSayingController class 의 remove 함수 실행 인자 값 rq 넣어줌
				break;	// break 만나 switch 문 빠져나옴 다시 while 문으로 돌아가서 true 이기 때문에 다시 while 문 진행
			case "수정":	// ActionCode가 "수정" 일 case
				wiseSayingController.modify(rq); // wiseSayingController class 의 modify 함수 실행 인자 값 rq 넣어줌
				break;	// break 만나 switch 문 빠져나옴 다시 while 문으로 돌아가서 true 이기 때문에 다시 while 문 진행
			default: // case 조건 외 일 경우
				System.out.println("존재하지 않는 명령어입니다"); // 존재하지 않는 명령어입니다 출력 
				break; // switch 문 빠져 나오고 다시 while 문으로 반복 진행 
			}
		}

	}
}