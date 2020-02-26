package com.altersoftware.hotel.util;
import com.altersoftware.hotel.checkIn.faceIdCompere.GetUrlPic;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

/**
 * @Author 廿八十
 * @Date 2020/2/22 22:25
 * @Version 1.0
 */
public class FaceIR {

        public static boolean scanVivo()throws Exception {
            //从官网获取
            String appId = "GLF2xG5aoZwGsfdMnbv1oBrVjfU9o3GWsVNFr6M9e6gX";
            String sdkKey = "GYAXVfmdLq6tejWfBTW8KiBeQ5JaxcoUoZ7EUzyJ43W";

            String path = ResourceUtils.getFile("classpath:static/dll").getPath();
            FaceEngine faceEngine = new FaceEngine(path);
            //激活引擎
            int errorCode = faceEngine.activeOnline(appId, sdkKey);
            GetUrlPic getUrlPic = new GetUrlPic();
            if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
                System.out.println("引擎激活失败");
                System.out.println(errorCode);
            }
            ActiveFileInfo activeFileInfo=new ActiveFileInfo();
            errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
            if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
                System.out.println("获取激活文件信息失败");
            }

            //引擎配置
            EngineConfiguration engineConfiguration = new EngineConfiguration();
            engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
            engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
            engineConfiguration.setDetectFaceMaxNum(10);
            engineConfiguration.setDetectFaceScaleVal(16);
            //功能配置
            FunctionConfiguration functionConfiguration = new FunctionConfiguration();
            functionConfiguration.setSupportAge(true);
            functionConfiguration.setSupportFace3dAngle(true);
            functionConfiguration.setSupportFaceDetect(true);
            functionConfiguration.setSupportFaceRecognition(true);
            functionConfiguration.setSupportGender(true);
            functionConfiguration.setSupportLiveness(true);
            functionConfiguration.setSupportIRLiveness(true);
            engineConfiguration.setFunctionConfiguration(functionConfiguration);


            //初始化引擎
            errorCode = faceEngine.init(engineConfiguration);

            if (errorCode != ErrorInfo.MOK.getValue()) {
                System.out.println("初始化引擎失败");
            }
            //人脸检测
	        String pathLive = ResourceUtils.getURL("classpath:static/").getPath();
            ImageInfo imageInfo = getRGBData(new File(pathLive+"tmp.jpg"));
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
            System.out.println(faceInfoList);

            //特征提取
            FaceFeature faceFeature = new FaceFeature();
            errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);

            //设置活体测试
            errorCode = faceEngine.setLivenessParam(0.5f, 0.7f);

            //人脸属性检测
            FunctionConfiguration configuration = new FunctionConfiguration();
            configuration.setSupportAge(true);
            configuration.setSupportFace3dAngle(true);
            configuration.setSupportGender(true);
            configuration.setSupportLiveness(true);
            errorCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList, configuration);

            //活体检测
            List<LivenessInfo> livenessInfoList = new ArrayList<LivenessInfo>();
            errorCode = faceEngine.getLiveness(livenessInfoList);
            int Flag = livenessInfoList.get(0).getLiveness();
            if (Flag == 1){
	            return true;
            }
            else{
	            return false;
            }

        }


}
