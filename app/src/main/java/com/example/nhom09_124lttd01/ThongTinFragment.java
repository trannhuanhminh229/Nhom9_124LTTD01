package com.example.nhom09_124lttd01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongTinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongTinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThongTinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThongTinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThongTinFragment newInstance(String param1, String param2) {
        ThongTinFragment fragment = new ThongTinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("groups");

        Group group1 = new Group("Nguyễn Quốc Cường", "22115053122308", "124LTTD01");
        myRef.push().setValue(group1);

        Group group2 = new Group("Trần Như Anh Minh", "22115053122229", "124LTTD01");
        myRef.push().setValue(group2);

        View view = inflater.inflate(R.layout.fragment_thong_tin, container, false);
        TextView textView = view.findViewById(R.id.textView);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textView.setText("");
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Group group1 = dataSnapshot.getValue(Group.class);
                    if (group1 != null) {
                        textView.append("Họ tên: " + group1.hoten + "\n");
                        textView.append("Mã sinh viên: " + group1.masinhvien + "\n");
                        textView.append("Lớp học phần : " + group1.lophocphan + "\n\n");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi nếu có
            }
        });

        return view;
    }

}