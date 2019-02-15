package com.resonatestudios.seminar_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resonatestudios.seminar_recyclerview.adapter.StudentAdapter;
import com.resonatestudios.seminar_recyclerview.model.DbStudents;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DbStudents.Student> students;
    DbStudents dbStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        students = new ArrayList<>();

        dbStudents = new DbStudents(this);
        dbStudents.open();
        dbStudents.insert("Abel", "123");
        dbStudents.insert("Ilham", "123");
        dbStudents.insert("Putri", "123");
        students.addAll(dbStudents.getAll());
        dbStudents.close();

        showRecyclerView();
    }

    private void showRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        StudentAdapter studentAdapter = new StudentAdapter();
        studentAdapter.setStudentArrayList(students);
        recyclerView.setAdapter(studentAdapter);
    }
}
