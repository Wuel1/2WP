// Generated by view binder compiler. Do not edit!
package com.example.ufrpelogin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ufrpelogin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RadioButton buttonAluno;

  @NonNull
  public final Button buttonEntrar;

  @NonNull
  public final RadioButton buttonProfessor;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull RadioButton buttonAluno,
      @NonNull Button buttonEntrar, @NonNull RadioButton buttonProfessor) {
    this.rootView = rootView;
    this.buttonAluno = buttonAluno;
    this.buttonEntrar = buttonEntrar;
    this.buttonProfessor = buttonProfessor;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_aluno;
      RadioButton buttonAluno = ViewBindings.findChildViewById(rootView, id);
      if (buttonAluno == null) {
        break missingId;
      }

      id = R.id.button_entrar;
      Button buttonEntrar = ViewBindings.findChildViewById(rootView, id);
      if (buttonEntrar == null) {
        break missingId;
      }

      id = R.id.button_professor;
      RadioButton buttonProfessor = ViewBindings.findChildViewById(rootView, id);
      if (buttonProfessor == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, buttonAluno, buttonEntrar,
          buttonProfessor);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}