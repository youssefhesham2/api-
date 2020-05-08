package com.example.apipostupdatedelete.Ui.addempolyee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apipostupdatedelete.Models.EmpolyeeModel;
import com.example.apipostupdatedelete.R;
import com.example.apipostupdatedelete.Ui.MainActivity;
import com.example.apipostupdatedelete.data.RetrofitClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmpolyee extends AppCompatActivity {

    String empolyeename,empolyesalary,empolyeage;
    Button addnewempolyee;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_empolyee);
        intialview();
    }

    private void intialview() {
        EditText empolyee_name,Empolyee_salary,Empolyee_age;
        empolyee_name = findViewById(R.id.empolyeename2);
        Empolyee_salary = findViewById(R.id.salary2);
        Empolyee_age = findViewById(R.id.age2);
        addnewempolyee=findViewById(R.id.addnewempolyee);

        Intent intent=getIntent();
         id=intent.getStringExtra("id");
        String name=intent.getStringExtra("employee_name");
        String salary=intent.getStringExtra("employee_salary");
        String age=intent.getStringExtra("employee_age");
        empolyee_name.setText(name);
        Empolyee_salary.setText(salary);
        Empolyee_age.setText(age);

         empolyeename=empolyee_name.getText().toString();
         empolyesalary=Empolyee_salary.getText().toString();
         empolyeage=Empolyee_age.getText().toString();

        if(empolyeename.isEmpty())
        {
            addnewempolyee.setText("add new empolyee");
        }
    }
    public void add(View view) {


        if(empolyeename.isEmpty())
        {
            add();
        }
        else{

            update();

        }



     /*   HashMap<Object,Object> map=new HashMap<>();
        map.put("employee_name",empolyeename);
        map.put("employee_salary",empolyesalary);
        map.put("employee_age",empolyeage);
        map.put("profile_image","");*/


      /*  RetrofitClient.RetrofitInstance().post3(map).enqueue(new Callback<EmpolyeeModel.data>() {
            @Override
            public void onResponse(Call<EmpolyeeModel.data> call, Response<EmpolyeeModel.data> response) {
                if (response.isSuccessful()&&response.code()==200)
                {


                    //Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    TextView tt=findViewById(R.id.ee);
                    tt.setText(response.body().getId()+"/"+response.body().getEmployee_name()+"/"+response.body().getEmployee_salary()+"/"+response.body().getEmployee_age());
                    Toast.makeText(AddEmpolyee.this,"sucssful add", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(AddEmpolyee.this, "aaaa", Toast.LENGTH_SHORT).show();

                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EmpolyeeModel.data> call, Throwable t) {
                Toast.makeText(AddEmpolyee.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AddEmpolyee.this, "ssss", Toast.LENGTH_SHORT).show();

            }
        });*
       */

      /*  RetrofitClient.RetrofitInstance().post(new EmpolyeeModel().new data(empolyeename,empolyesalary,empolyeage,"")).enqueue(new Callback<EmpolyeeModel.data>() {
            @Override
            public void onResponse(Call<EmpolyeeModel.data> call, Response<EmpolyeeModel.data> response) {
                if (response.isSuccessful()&&response.code()==200)
                {


                    //Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    TextView tt=findViewById(R.id.ee);
                    tt.setText(response.body().getId()+"/"+response.body().getEmployee_name()+"/"+response.body().getEmployee_salary()+"/"+response.body().getEmployee_age());
                    Toast.makeText(AddEmpolyee.this,"sucssful add", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(AddEmpolyee.this, "aaaa", Toast.LENGTH_SHORT).show();

                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EmpolyeeModel.data> call, Throwable t) {
                Toast.makeText(AddEmpolyee.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AddEmpolyee.this, "ssss", Toast.LENGTH_SHORT).show();

            }
        });*/
        /*RetrofitClient.RetrofitInstance().post2("yyyy",empolyesalary,empolyeage,"").enqueue(new Callback<EmpolyeeModel.data>() {
            @Override
            public void onResponse(Call<EmpolyeeModel.data> call, Response<EmpolyeeModel.data> response) {
                if (response.isSuccessful()&&response.code()==200)
                {

                    //Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    TextView tt=findViewById(R.id.ee);
                    tt.setText(response.body().getId()+"/"+response.body().getEmployee_name()+"/"+response.body().getEmployee_salary()+"/"+response.body().getEmployee_age());
                    Toast.makeText(AddEmpolyee.this,"sucssful add", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(AddEmpolyee.this, "aaaa", Toast.LENGTH_SHORT).show();

                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EmpolyeeModel.data> call, Throwable t) {
                Toast.makeText(AddEmpolyee.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AddEmpolyee.this, "ssss", Toast.LENGTH_SHORT).show();

            }
        });*/
    }
    void  add(){
        if(empolyeename.isEmpty()){
            Toast.makeText(getApplicationContext(), "please enter empolyee name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(empolyesalary.isEmpty()){
            Toast.makeText(getApplicationContext(), "please enter empolyee salary", Toast.LENGTH_SHORT).show();
            return;
        }
        if(empolyeage.isEmpty()){
            Toast.makeText(getApplicationContext(), "please enter empolyee age", Toast.LENGTH_SHORT).show();
            return;
        }

        RetrofitClient.RetrofitInstance().post(new EmpolyeeModel().new data(empolyeename,empolyesalary,empolyeage,"")).enqueue(new Callback<EmpolyeeModel.data>() {
            @Override
            public void onResponse(Call<EmpolyeeModel.data> call, Response<EmpolyeeModel.data> response) {
                if (response.isSuccessful()&&response.code()==200)
                {


                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    TextView tt=findViewById(R.id.ee);
                    tt.setText(response.body().getId()+"/"+response.body().getEmployee_name()+"/"+response.body().getEmployee_salary()+"/"+response.body().getEmployee_age());
                    Toast.makeText(AddEmpolyee.this,"sucssful add", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(AddEmpolyee.this, "aaaa", Toast.LENGTH_SHORT).show();

                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AddEmpolyee.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EmpolyeeModel.data> call, Throwable t) {
                Toast.makeText(AddEmpolyee.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AddEmpolyee.this, "ssss", Toast.LENGTH_SHORT).show();

            }
        });

    }
    void update(){

        RetrofitClient.RetrofitInstance().put(Integer.parseInt(id),new EmpolyeeModel().new data(empolyeename,empolyesalary,empolyeage,"")).enqueue(new Callback<EmpolyeeModel.data>() {
            @Override
            public void onResponse(Call<EmpolyeeModel.data> call, Response<EmpolyeeModel.data> response) {
                if (response.isSuccessful()&&response.code()==200)
                {
                    Toast.makeText(getApplicationContext(), "Succsseful", Toast.LENGTH_SHORT).show();
                    TextView tt=findViewById(R.id.ee);
                    tt.setText(response.body().getId()+"/"+response.body().getEmployee_name()+"/"+response.body().getEmployee_salary()+"/"+response.body().getEmployee_age());
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<EmpolyeeModel.data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}

