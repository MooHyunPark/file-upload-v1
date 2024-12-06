package com.metacoding.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UploadService {

    private final UploadRepository uploadRepository;

    @Transactional
    public void v1사진저장(UploadRequest.V1DTO v1DTO){
        // static 메서드로 프로젝트에 이미지를 저장한 뒤 db에 저장할 dbUrl 문자열을 반환합니다.
        String dbUrl = FileUtil.fileSave(v1DTO.getImg());

        // db에 저장
        uploadRepository.save(v1DTO.toEntity(dbUrl));

    }

    public Upload 사진보기() {
        return uploadRepository.findById(1);
    }

    @Transactional
    public void v2사진저장(UploadRequest.V2DTO v2DTO) {
        String profileUrl = FileUtil.fileSave(v2DTO.getImg());

        uploadRepository.save(v2DTO.toEntity(profileUrl));

    }
}