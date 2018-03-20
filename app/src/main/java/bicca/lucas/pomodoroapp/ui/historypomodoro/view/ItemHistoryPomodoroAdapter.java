package bicca.lucas.pomodoroapp.ui.historypomodoro.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import bicca.lucas.pomodoroapp.BR;
import bicca.lucas.pomodoroapp.R;
import bicca.lucas.pomodoroapp.ui.model.Pomodoro;

public class ItemHistoryPomodoroAdapter extends RecyclerView.Adapter<ItemHistoryPomodoroAdapter.ItemHistoryPomodoroViewHolder> {

    private ArrayList<Pomodoro> items;
    private Context context;

    public ItemHistoryPomodoroAdapter(ArrayList<Pomodoro> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ItemHistoryPomodoroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new ItemHistoryPomodoroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemHistoryPomodoroViewHolder holder, int position) {
        Pomodoro item = items.get(position);
        item.setContext(context);
        holder.bind(item);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_history;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHistoryPomodoroViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public ItemHistoryPomodoroViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object object) {
            binding.setVariable(BR.itemHistoryViewModel, object);
            binding.executePendingBindings();
        }
    }
}
