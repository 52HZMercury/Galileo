package com.galileo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class ModelCaller {
    /**
     * @Description: http调用
     * @Param:
     * @return:
     */

    private static final String RECOGNIZE_URL = "http://47.96.119.233:5001/recognize";

    /**
     * 通过HTTP POST请求调用识别接口并返回结果。
     * @param filepath 文件路径
     * @return 接口返回的JSON字符串
     * @throws Exception 如果发生错误
     */
    public Map<String, Float> recognize(String filepath) throws Exception {
        URL url = new URL(RECOGNIZE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String input = "{\"filepath\":\"" + filepath + "\"}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] inputBytes = input.getBytes("utf-8");
            os.write(inputBytes, 0, inputBytes.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        System.out.println(response);

        // 解析 JSON 字符串
        JSONObject jsonObject = JSON.parseObject(response.toString());
        // 获取 "data" 对象  直接转换为map对象
        JSONObject dataObject = jsonObject.getJSONObject("data");
        Map<String, Float> planetMap = dataObject.toJavaObject(Map.class);

        //planetMap.put(dataObject.keySet().toArray()[0].toString(),dataObject.getFloatValue(dataObject.keySet().toArray()[0].toString()));

        return planetMap;
    }

    public static void main(String[] args) throws Exception {
        //test
        Map<String, Float> result = new ModelCaller().recognize("/www/wwwroot/Galileo/postsImages/jutiper.jpg");
        System.out.println(result.keySet().toArray()[0]);
    }

}


//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        //部署的模型的地址
//        HttpPost httpPost = new HttpPost("http://10.33.17.92:5001/uploadRecognizePlanet");
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

//public static map<String, String> planetidentify(String filename) {
//        public static void main (String[] args){
//            try (OrtEnvironment env = OrtEnvironment.getEnvironment()) {
//                // 初始化SessionOptions
//                SessionOptions sessionOptions = new SessionOptions();
//
//                // 加载ONNX模型
//                String modelPath = "path_to_your_model.onnx";
//                try (Session session = env.createSession(modelPath, sessionOptions)) {
//
//                    // 获取模型输入和输出的信息
//                    TensorInfo[] inputInfos = session.getInputTypeInfo();
//                    TensorInfo[] outputInfos = session.getOutputTypeInfo();
//
//                    // 假设模型有一个名为"data"的输入，其类型为float，维度为[1, 224, 224, 3]
//                    int[] inputDims = new int[]{1, 224, 224, 3};
//                    FloatBuffer inputData = FloatBuffer.allocate(1 * 224 * 224 * 3); // 填充真实输入数据
//
//                    // 创建输入Tensor
//                    OnnxTensor inputTensor = OnnxTensor.createTensor(env, inputData, inputDims);
//
//                    // 执行模型推理
//                    OnnxTensor[] outputs = session.run(new OnnxTensor[]{inputTensor});
//
//                    // 获取第一个输出结果
//                    float[] predictionArray = outputs[0].getValue().asFloatBuffer().array();
//
//                    // 进一步处理预测结果
//                    processPredictionResults(predictionArray);
//
//                    // 清理资源
//                    inputTensor.close();
//                    for (OnnxTensor output : outputs) {
//                        output.close();
//                    }
//                }
//            } catch (OnnxRuntimeException e) {
//                System.out.println("Error occurred while loading or running the model: " + e.getMessage());
//            }
//        }
//
//        private static void processPredictionResults ( float[] predictionArray){
//            // 在这里处理预测结果
//        }
//
//
//    }
