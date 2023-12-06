package com.larrex.thelibrary.liberian.controller;

import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("liberian/v1")
@RequiredArgsConstructor
public class LiberianController {

    private final LiberianService liberianService;

    @PostMapping()
    public Liberian createLiberian (@RequestBody LiberianModel liberianModel){
        return liberianService.createLiberian(liberianModel);
    }

    @PutMapping("/{id}")
    public Liberian updateLiberian(@PathVariable(name = "id") Long id,@RequestBody LiberianModel liberianModel){
        return liberianService.updateLiberian(liberianModel,id);
    }

    @PostMapping("/upload")
    public Liberian uploadImage(@RequestParam("file")MultipartFile multipartFile,@RequestParam(name = "id") Long id) throws IOException {
        return liberianService.uploadImage(multipartFile, id);
    }

    @GetMapping("/profile/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable(name = "filename") String filename) throws IOException {
        return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body( liberianService.downloadImage(filename));
    }

    @GetMapping("/{id}")
    public Liberian getLiberian(@PathVariable(name = "id") Long id){
        return liberianService.getLiberianById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        liberianService.delete(id);
    }

}
