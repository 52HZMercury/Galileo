package com.galileoastronomycommunity.util;

import ai.onnxruntime.*;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.SessionOptions;
import ai.onnxruntime.TensorInfo;
import ai.onnxruntime.capi.OnnxTensor;
import ai.onnxruntime.exceptions.OnnxRuntimeException;
import ai.onnxruntime.Session;

import ai.onnxruntime.OrtSession.Result;
import ai.onnxruntime.OrtSession.SessionOptions;
import ai.onnxruntime.OrtSession.SessionOptions.ExecutionMode;
import ai.onnxruntime.OrtSession.SessionOptions.OptLevel;
public class ModelCaller {
    /**
     * @Description: http调用
     * @Param:
     * @return:
     */
    public static map<String, String> planetidentify(String filename) {
        public static void main (String[] args){
            try (OrtEnvironment env = OrtEnvironment.getEnvironment()) {
                // 初始化SessionOptions
                SessionOptions sessionOptions = new SessionOptions();

                // 加载ONNX模型
                String modelPath = "path_to_your_model.onnx";
                try (Session session = env.createSession(modelPath, sessionOptions)) {

                    // 获取模型输入和输出的信息
                    TensorInfo[] inputInfos = session.getInputTypeInfo();
                    TensorInfo[] outputInfos = session.getOutputTypeInfo();

                    // 假设模型有一个名为"data"的输入，其类型为float，维度为[1, 224, 224, 3]
                    int[] inputDims = new int[]{1, 224, 224, 3};
                    FloatBuffer inputData = FloatBuffer.allocate(1 * 224 * 224 * 3); // 填充真实输入数据

                    // 创建输入Tensor
                    OnnxTensor inputTensor = OnnxTensor.createTensor(env, inputData, inputDims);

                    // 执行模型推理
                    OnnxTensor[] outputs = session.run(new OnnxTensor[]{inputTensor});

                    // 获取第一个输出结果
                    float[] predictionArray = outputs[0].getValue().asFloatBuffer().array();

                    // 进一步处理预测结果
                    processPredictionResults(predictionArray);

                    // 清理资源
                    inputTensor.close();
                    for (OnnxTensor output : outputs) {
                        output.close();
                    }
                }
            } catch (OnnxRuntimeException e) {
                System.out.println("Error occurred while loading or running the model: " + e.getMessage());
            }
        }

        private static void processPredictionResults ( float[] predictionArray){
            // 在这里处理预测结果
        }


    }
}


//    //使用http调用部署在本地的模型
//    public static void main(String[] args) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        //部署的模型的地址
//        HttpPost httpPost = new HttpPost("http://localhost:8001/v1/models/your_model/infer");
//
//        // 假设模型接受JSON格式的输入数据
//        String jsonInputData = "{\"data\": [...]}"; // 替换为实际输入数据
//        StringEntity inputEntity = new StringEntity(jsonInputData, ContentType.APPLICATION_JSON);
//
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setEntity(inputEntity);
//
//        HttpResponse response = httpClient.execute(httpPost);
//        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//            String resultJson = EntityUtils.toString(response.getEntity());
//            // 解析并处理预测结果
//            processPredictionResult(resultJson);
//        }
//
//        httpClient.close();
//    }
//
//    private static void processPredictionResult(String resultJson) {
//        // 根据实际模型输出格式解析并处理结果
//    }
