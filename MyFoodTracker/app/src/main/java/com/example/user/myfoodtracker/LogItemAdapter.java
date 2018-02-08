package com.example.user.myfoodtracker;

import android.support.v7.widget.RecyclerView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.example.user.myfoodtracker.AppDatabase;
import com.example.user.myfoodtracker.R;
import com.example.user.myfoodtracker.LogsActivity;
import com.example.user.myfoodtracker.UpdateLogItemActivity;
import com.example.user.myfoodtracker.LogItem;

/**
 * Created by user on 08/02/2018.
 */

public class LogItemAdapter extends RecyclerView.Adapter<LogItemAdapter.ViewHolder> {
    private List<LogItem> mlogItemList;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView logItemTitleTv;
        public TextView logItemDateTv;
        public TextView logItemTimeTv;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            logItemTitleTv = (TextView) v.findViewById(R.id.logTitle);
            logItemDateTv = (TextView) v.findViewById(R.id.logDate);
            logItemTimeTv = (TextView) v.findViewById(R.id.logTime);


        }
    }

    public LogItemAdapter(List<LogItem> logs, Context context, RecyclerView recyclerView){
        mlogItemList = logs;
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public LogItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.log_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final LogItem logItem = mlogItemList.get(position);
        holder.logItemTitleTv.setText(logItem.getLogItemTitle());
        holder.logItemDateTv.setText(logItem.getLogItemDate());
        holder.logItemTimeTv.setText(logItem.getLogItemTime());
        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete user?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToLogItemUpdateActivity(logItem.getLogItemId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AppDatabase appDatabase = AppDatabase.getAppDatabase(mContext);
                        appDatabase.getLogItemDao().delete(mlogItemList.get(position));

                        mlogItemList.remove(position);
                        mRecyclerView.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, mlogItemList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });


    }
    private void goToLogItemUpdateActivity(long logItemId){
        Intent goToUpdate = new Intent(mContext, UpdateLogItemActivity.class);
        goToUpdate.putExtra("USER_ID", logItemId);
        mContext.startActivity(goToUpdate);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mlogItemList.size();
    }
}
