package com.example.livewell;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends BaseActivity 
{
	private EditText editCurrentWeight, editGoalWeight;
	private RadioGroup radioGender, radioExercise;
	private RadioButton radioGenderButton, radioExerciseButton;
	private CheckBox chkAgreement;
	private Button submitButton;
	final Context context = this;
	
	SharedPreferences settings;
	
	protected void onCreate(Bundle savedInstanceState) 
	{		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		settings = getSharedPreferences(SETTINGS_PREFS, Context.MODE_APPEND);

		addListenerOnButton();
	}
	
	public void addListenerOnButton()
	{
		editCurrentWeight = (EditText)findViewById(R.id.editText_enterWeight);
		editGoalWeight = (EditText)findViewById(R.id.editText_enterGoal);
		radioGender = (RadioGroup)findViewById(R.id.radioGender);
		radioExercise = (RadioGroup)findViewById(R.id.radioExercise);
		chkAgreement = (CheckBox)findViewById(R.id.chkAgreement);
		submitButton = (Button)findViewById(R.id.btnSubmit);
		
		submitButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// get weight
				String currentWeight = editCurrentWeight.getText().toString().trim();
				String goalWeight = editGoalWeight.getText().toString().trim();
				
				// get gender
				int radioGenderId = radioGender.getCheckedRadioButtonId();
				radioGenderButton = (RadioButton)findViewById(radioGenderId);
				String gender = radioGenderButton.getText().toString().trim();
				
				// get exercise preference
				int radioExerciseId = radioExercise.getCheckedRadioButtonId();
				radioExerciseButton = (RadioButton)findViewById(radioExerciseId);
				String exercisePref = radioExerciseButton.getText().toString().trim();
				
				if(chkAgreement.isChecked())
				{
					int currentWeightInt = Integer.valueOf(currentWeight);
					int goalWeightInt = Integer.valueOf(goalWeight);
					int lostWeightInt = currentWeightInt - goalWeightInt;
					
					// set custom dialog
					final Dialog dietDialog = new Dialog(context);
					dietDialog.setContentView(R.layout.activity_dialog);
					dietDialog.setTitle("Based on your input...");
					
					// set custom dialog components
					TextView text1 = (TextView)dietDialog.findViewById(R.id.textview_caloriesIntake);
					text1.setText("You would like to weight "+goalWeight +" lbs. You must eat 1,500 calories per day.");
					TextView text2 = (TextView)dietDialog.findViewById(R.id.textview_dietDuration);
					text2.setText("With this diet, you will lose " +lostWeightInt +" lbs in 5 weeks.");
					ImageView image = (ImageView)dietDialog.findViewById(R.id.image_androideatapple);
					image.setImageResource(R.drawable.androideatapple);
					
					Button recalculateButton = (Button)dietDialog.findViewById(R.id.btn_recalculate);
					// if button is clicked, close the custom dialog
					recalculateButton.setOnClickListener(new OnClickListener()
					{
						public void onClick(View v) 
						{
							dietDialog.dismiss();
						}
						
					});

					Button acceptButton = (Button)dietDialog.findViewById(R.id.btn_accept);
					// if button is clicked, go to the next activity
					acceptButton.setOnClickListener(new OnClickListener()
					{
						public void onClick(View v) 
						{
							startActivity(new Intent(Profile.this, Calendar.class));
						}
						
					});
					
					dietDialog.show();
				}
				else
				{
					Toast.makeText(Profile.this, "Please read and agree to the Disclaimer!", Toast.LENGTH_SHORT).show();
				}
			}
		}
		);
	}
	

}