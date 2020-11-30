package cl.example.desafiopassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import cl.example.desafiopassword.databinding.ActivityMainBinding;
import cl.example.desafiopassword.presenter.IPresenterView;
import cl.example.desafiopassword.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IPresenterView {
    public ActivityMainBinding binding;
    public Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter=new Presenter(this);
        binding.editTextPass.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.evaluatePass(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

    }


    @Override
    public void showWeak() {
        binding.textView.setText(R.string.debil);
        binding.textView.setBackgroundColor(Color.RED);
    }

    @Override
    public void showMedium() {
        binding.textView.setText(R.string.media);
        binding.textView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void showStrong() {
        binding.textView.setText(R.string.fuerte);
        binding.textView.setBackgroundColor(Color.GREEN);
    }
}