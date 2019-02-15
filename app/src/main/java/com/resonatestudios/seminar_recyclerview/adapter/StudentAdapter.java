package com.resonatestudios.seminar_recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.resonatestudios.seminar_recyclerview.R;
import com.resonatestudios.seminar_recyclerview.model.DbStudents;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Holder> {
    private ArrayList<DbStudents.Student> studentArrayList;

    public ArrayList<DbStudents.Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<DbStudents.Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);
        return new Holder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        DbStudents.Student row = getStudentArrayList().get(i);

        holder.name.setText(row.name);
        holder.phone.setText(row.phone);
    }

    @Override
    public int getItemCount() {
        return getStudentArrayList().size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
