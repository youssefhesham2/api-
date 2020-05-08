package com.example.apipostupdatedelete.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apipostupdatedelete.Models.EmpolyeeModel;
import com.example.apipostupdatedelete.R;
import com.example.apipostupdatedelete.Ui.addempolyee.AddEmpolyee;
import com.example.apipostupdatedelete.data.RetrofitClient;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    empolyeeadpter empolyeeadpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialrecycler();
        getdata();
    }

    private void getdata() {
        RetrofitClient.RetrofitInstance().get().enqueue(new Callback<EmpolyeeModel>() {
            @Override
            public void onResponse(Call<EmpolyeeModel> call, Response<EmpolyeeModel> response) {
                if(response.isSuccessful()&&response.code()==200){
                    List<EmpolyeeModel.data> empolyeeModels=response.body().getData();
                    if(empolyeeModels!=null){
                        empolyeeadpter=new empolyeeadpter(empolyeeModels);
                        recyclerView.setAdapter(empolyeeadpter);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<EmpolyeeModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ssss", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void intialrecycler() {
        recyclerView=findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void addintent(View view) {
        Intent intent=new Intent(getApplicationContext(), AddEmpolyee.class);
        startActivity(intent);
    }
    class empolyeeadpter extends RecyclerView.Adapter<empolyeeadpter.emVH>{
        List<EmpolyeeModel.data> empolyeeModels;

        public empolyeeadpter(List<EmpolyeeModel.data> empolyeeModels) {
            this.empolyeeModels = empolyeeModels;
        }

        @NonNull
        @Override
        public emVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.item,parent,false);
            return new emVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull emVH holder, int position) {
            final EmpolyeeModel.data empolyeeModel=empolyeeModels.get(position);

            String id=empolyeeModel.getId();
            String employee_name=empolyeeModel.getEmployee_name();
            final String employee_salary=empolyeeModel.getEmployee_salary();
            final String employee_age=empolyeeModel.getEmployee_age();

            holder.id.setText(id);
            holder.empolyee_name.setText(employee_name);
            holder.employee_salary.setText(employee_salary);
            holder.employee_age.setText(employee_age);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(), AddEmpolyee.class);
                    intent.putExtra("id",empolyeeModel.getId());
                    intent.putExtra("employee_name",empolyeeModel.getEmployee_name());
                    intent.putExtra("employee_salary",employee_salary);
                    intent.putExtra("employee_age",employee_age);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return empolyeeModels.size();
        }

        class emVH extends RecyclerView.ViewHolder{

            TextView id,empolyee_name,employee_salary,employee_age;
            public emVH(@NonNull View itemView) {
                super(itemView);
                id=itemView.findViewById(R.id.id);
                empolyee_name=itemView.findViewById(R.id.empolyeename);
                employee_salary=itemView.findViewById(R.id.employee_salary);
                employee_age=itemView.findViewById(R.id.employee_age);
            }
        }
    }
}
