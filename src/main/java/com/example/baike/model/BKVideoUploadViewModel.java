package com.example.baike.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BKVideoUploadViewModel extends BKInteractiveVideo{
    /**
     * 要上传的一组视频的id
     */
    @NotNull(message = "视频不能为空")
    private List<String> videoFilesUUID;

    /**
     * 视频名称
     */
    @NotNull(message = "视频不能为空")
    private List<String> videoNames;

    /**
     * 封面id
     */
    @NotNull(message = "封面不能为空")
    private String coverUUID;

}
