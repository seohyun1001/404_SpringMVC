package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.ReplyDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

  @Tag(name = "Replies POST", description = "POST 방식으로 댓글 등록")
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  // ResponseEntity, 데이터를 HTTP 상태 코드와 같이 , 앞단에 전달하기.
  // JSON  타입의 문자열로 전달시 사용하고,
  // 서버에 도착하면 JSON -> ReplyDTO 타입으로 자동으로 변환,
  // Jackson 라이브러리가, 컨버터 역할. 기본 탑재,
  // 요청시, ReplyDTO 의 타입으로, application/json 마임 타입으로 전달 해야함.
  public ResponseEntity<Map<String, Long>> register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {

    log.info(replyDTO);

    // 더미 데이터 넣기 1
//    Map<String, Long> resultMap = Map.of("rno",123L);
    // 오류 및 , 유효성 체크등 오류 발생시, 에러 표시.
    if (bindingResult.hasErrors()) {
      throw new BindException(bindingResult);
    }

    // 더미데이터 넣기 2
    Map<String, Long> resultMap = new HashMap<>();
    resultMap.put("rno",1234L);


    return ResponseEntity.ok(resultMap);
  }
}
