package com.example.nhom09_124lttd01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {

    private List<SanPham> msanPhams;

    public void setData(List<SanPham> list) {
        this.msanPhams = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_sanpham, parent, false);

        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {

        SanPham sanPham = msanPhams.get(position);
        if (sanPham == null) {
            return;
        }

        holder.imgSanPham.setImageResource(sanPham.getResourceID());
        holder.tenSanPham.setText(sanPham.getTittle());
        holder.giaSanPham.setText(sanPham.getPrice());

    }

    @Override
    public int getItemCount() {

        if(msanPhams != null) {
            return msanPhams.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgSanPham;
        private TextView tenSanPham;
        private TextView giaSanPham;


        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSanPham = itemView.findViewById(R.id.img_sanpham);
            tenSanPham = itemView.findViewById(R.id.ten_sanpham);
            giaSanPham = itemView.findViewById(R.id.gia_sanpham);
        }
    }
}
