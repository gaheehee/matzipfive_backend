package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")  //hi라는 url 입력 시 이 메소드 실행
    // 아래의 메소드를 가지고 mustache view 페이지를 반환하도록 만듦
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "gahee");
        return "greetings";    // templates/greeting.mustache를 찾아서 브라우저로 전송해줌
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","gaheehee");
        return "goodbye";
    }
}
