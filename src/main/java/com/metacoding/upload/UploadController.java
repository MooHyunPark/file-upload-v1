package com.metacoding.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UploadController {

    private final UploadService uploadService;

    // form 태그 이용
    @GetMapping("/file1")
    public String file1() {
        return "file1";
    }

    @PostMapping("/v1/upload")
    public String v1Upload(UploadRequest.V1DTO v1DTO) {
        uploadService.v1사진저장(v1DTO);
        return "index";
    }

    @GetMapping("/file1-check")
    public String v1FileCheck(Model model) {

        // DTO 변환 생략
        Upload upload = uploadService.사진보기();
        model.addAttribute("model", upload);
        return "file1-check";
    }




    // ajax 이용
    @GetMapping("/file2")
    public String file2() {

        return "file2";
    }

    @PostMapping("/v2/upload")
    public ResponseEntity<?> v2Upload(@RequestBody UploadRequest.V2DTO v2DTO) {
        uploadService.v2사진저장(v2DTO);
        Resp resp = new Resp(true, "성공", null);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/file2-check")
    public String v2FileCheck(Model model) {

        // DTO 변환 생략
        Upload upload = uploadService.사진보기();
        model.addAttribute("model", upload);
        return "file2-check";
    }
}
