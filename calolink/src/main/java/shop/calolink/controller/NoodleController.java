package shop.calolink.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/noodles")
public class NoodleController {

    @GetMapping
//    @RequestMapping("/{id}")
    public String noodle() {
        // 면류 하나의 정보를 담아서 반환
        log.info("페이지 접근 성공");
        return "ok";
    }

//    new ResponseEntity

    // 추가로 삭제, 수정 로직도 만들어야 됨
}
