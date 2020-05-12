package com.huatec.hiot_cloud.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huatec.hiot_cloud.R;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

public class TestGsonActivity extends AppCompatActivity {

    private static final String TAG = "TestGsonActivity";
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gson);

        //Json转对象
        Button btnFromJson = findViewById(R.id.btn_from_json);
        btnFromJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = gson.fromJson("{\n" +
                        "\t\"age\": 20,\n" +
                        "\t\"married\": false,\n" +
                        "\t\"name\": \"张三\"\n" +
                        "}",Student.class);
                if (student != null) {
                    String str = String.format("姓名：%s, 年龄：&d, 婚否：%b",
                            student.getName(), student.getAge(), student.isMarried());
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //对象转Json
        Button btnToJson = findViewById(R.id.btn_to_json);
        btnToJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student2 = new Student();
                student2.setName("张三");
                student2.setAge(50);
                student2.setMarried(true);
                String json = gson.toJson(student2);
                Log.d(TAG, "onClick: " + json);
            }
        });

        //Json转列表
        Button btnGsonList = findViewById(R.id.btn_gson_list);
        btnGsonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "[\n" +
                        "\t{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"age\": 21,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"李四\"\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"age\": 22,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"王五\"\n" +
                        "\t}\n" +
                        "]";
                Type type = new TypeToken<List<Student>>(){}.getType();
                List<Student> studentList = gson.fromJson(json, type);
                String str = "";
                if (studentList != null || !studentList.isEmpty()){
                    for (Student student : studentList){
                        str = str + String.format("姓名：%s, 年龄：&d, 婚否：%b",
                                student.getName(), student.getAge(), student.isMarried());
                    }
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Json转Map
        Button btnGsonMap = findViewById(R.id.btn_gson_map);
        btnGsonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "\t\"1\":{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t\"2\":{\n" +
                        "\t\t\"age\": 21,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"李四\"\n" +
                        "\t},\n" +
                        "\t\"3\":{\n" +
                        "\t\t\"age\": 22,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"王五\"\n" +
                        "\t}\n" +
                        "}";
                Type type = new TypeToken< Map<String ,Student>>(){}.getType();
                Map<String ,Student> map = gson.fromJson(json,type);
                String str = "";
                if (map != null){
                    for (String key : map.keySet()){
                        str = str + String.format("序号：%s,姓名：%s, 年龄：&d, 婚否：%b",
                                key,map.get(key).getName(), map.get(key).getAge(), map.get(key).isMarried());
                    }
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Json转嵌套对象
        Button btnGsonNest = findViewById(R.id.btn_gson_nest);
        btnGsonNest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "\t\"data\":\n" +
                        "\t{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t\"status\":1,\n" +
                        "\t\"msg\":\"正常\"\n" +
                        "}";
                Type type = new TypeToken<ResultBase<Student>>(){}.getType();
                ResultBase<Student> resultBase = gson.fromJson(json,type);
                String str = String.format("姓名：%s, 年龄：&d, 婚否：%b",
                        resultBase.data.getName(), resultBase.data.getAge(), resultBase.data.isMarried());;
                Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        //Json转嵌套对象(作业)
        Button btnGsonNest1 = findViewById(R.id.btn_gson_nest1);
        btnGsonNest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "\t\"data\":\n" +
                        "\t{\n" +
                        "\t\t\"id\": 101,\n" +
                        "\t\t\"graduated\": true,\n" +
                        "\t\t\"height\":175,\n" +
                        "\t\t\"name\": \"李四\"\n" +
                        "\t},\n" +
                        "\t\"status\":1,\n" +
                        "\t\"msg\":\"\"\n" +
                        "}";
                Type type = new TypeToken<ResultBase<People>>(){}.getType();
                ResultBase<People> resultBase = gson.fromJson(json,type);
                String str = String.format("姓名：%s,id：%s,身高：%d,毕业：%b",
                        resultBase.data.getName(),resultBase.data.getId(),resultBase.data.getHeight(),resultBase.data.isGraduated());
                Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: " + json);
            }
        });
    }
}
