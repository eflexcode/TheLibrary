package com.larrex.thelibrary.liberian.serviceImpl;

import com.larrex.thelibrary.Util;
import com.larrex.thelibrary.liberian.entity.Liberian;
import com.larrex.thelibrary.liberian.entity.model.LiberianModel;
import com.larrex.thelibrary.liberian.repository.LiberianRepository;
import com.larrex.thelibrary.liberian.service.LiberianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LiberianServiceImpl implements LiberianService {

    private final LiberianRepository liberianRepository;


    @Override
    public Liberian createLiberian(LiberianModel liberianModel) {

        Liberian liberian = new Liberian();
        BeanUtils.copyProperties(liberianModel,liberian);

        return liberianRepository.save(liberian);
    }

    @Override
    public Liberian updateLiberian(LiberianModel liberianModel, Long id) {

        Liberian liberian = liberianRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        liberian.setEmail(liberianModel.getEmail() != null ? liberianModel.getEmail() : liberian.getEmail());
        liberian.setPassword(liberianModel.getPassword() != null ? liberianModel.getPassword() : liberian.getPassword());
        liberian.setFullName(liberianModel.getFullName() != null ? liberianModel.getFullName() : liberian.getFullName());
        liberian.setImageUrl(liberianModel.getImageUrl() != null ? liberianModel.getImageUrl() : liberian.getImageUrl());


        return liberianRepository.save(liberian);
    }

    @Override
    public Liberian getLiberianById(Long id) {
        return liberianRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,""));
    }

    @Override
    public Liberian uploadImage(MultipartFile multipartFile, Long id) throws IOException {

//        String imageName = String.valueOf(System.currentTimeMillis()+multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
//        String downloadUrl = uploadUniversalPath+"/";
        String imageName =  Util.createFile(multipartFile);

//        File file = new File(Util.uploadUniversalPath,imageName);
////        file.createNewFile();
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write(multipartFile.getBytes());
//        fileOutputStream.close();

        LiberianModel liberianModel = new LiberianModel();
        liberianModel.setImageUrl(Util.downloadUniversalPath+imageName);


        return updateLiberian(liberianModel,id);
    }

    @Override
    public byte[] downloadImage(String filename) {

//        String filepath = Util.uploadUniversalPath+filename;
//        byte[] imageByte;
//        try {
//         imageByte = Files.readAllBytes(new File(filepath).toPath());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return imageByte;

        return Util.downloadImage(filename);
    }

    @Override
    public void delete(Long id) {

        liberianRepository.deleteById(id);

    }
}
