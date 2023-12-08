package com.fullstack.ds_back_coquin.service;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

    @Value("${minio.s3.endpoint}")
    private String endpoint;

    @Value("${minio.s3.examillustrations}")
    private String examIllustrations;

    @Value("${minio.s3.examphotos}")
    private String examPhotos;

    @Value("${minio.s3.accesskey}")
    private String accessKey;

    @Value("${minio.s3.secretkey}")
    private String privateKey;

    public void createBucketMinio(String bucket) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, privateKey)
                .build();

        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFileOnMinio(String path) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, privateKey)
                .build();

        try {
            minioClient.uploadObject(UploadObjectArgs
                    .builder()
                    .bucket(examIllustrations)
                    .object("POLYTECH_NANCY_Quadri_HD.png")
                    .filename(path).build());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFileViaPostman(File file, String path) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, privateKey)
                .build();

        try {
            minioClient.uploadObject(UploadObjectArgs
                    .builder()
                    .bucket(examPhotos)
                    .object(path)
                    .filename(file.getPath()).build());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}