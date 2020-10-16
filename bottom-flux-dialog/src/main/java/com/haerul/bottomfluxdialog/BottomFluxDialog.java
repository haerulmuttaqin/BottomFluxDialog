package com.haerul.bottomfluxdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public final class BottomFluxDialog {
    private static View view;
    private static BottomFluxDialog instance;
    private static BottomSheetDialog dialog;
    private static Button leftButton;
    private static Button rightButton;
    private static ImageView ivDialog;
    private static int imageDialog;
    private static TextView tvTitle;
    private static String textTitle;
    private static TextView tvMessage;
    private static String textMessage;
    
    private static BottomFluxDialog getInstance(){
        if(instance == null){
            instance = new BottomFluxDialog();
        }
        return instance;
    }
    
    public static BottomFluxDialog infoDialog(Context context) {
        view = ((Activity)context).getLayoutInflater().inflate(R.layout.info_dialog, null);
        leftButton = view.findViewById(R.id.a_btn);
        ivDialog = view.findViewById(R.id.image);
        tvTitle = view.findViewById(R.id.title);
        tvMessage = view.findViewById(R.id.message);

        dialog = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);
        
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return getInstance();
    }

    public static BottomFluxDialog alertDialog(final Context context) {
        view = ((Activity)context).getLayoutInflater().inflate(R.layout.info_dialog, null);
        leftButton = view.findViewById(R.id.a_btn);
        ivDialog = view.findViewById(R.id.image);
        tvTitle = view.findViewById(R.id.title);
        tvMessage = view.findViewById(R.id.message);

        dialog = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);

        return getInstance();
    }

    public static BottomFluxDialog confirmDialog(final Context context) {
        view = ((Activity)context).getLayoutInflater().inflate(R.layout.confirm_dialog, null);
        leftButton = view.findViewById(R.id.a_btn);
        rightButton = view.findViewById(R.id.b_btn);
        ivDialog = view.findViewById(R.id.image);
        tvTitle = view.findViewById(R.id.title);
        tvMessage = view.findViewById(R.id.message);

        dialog = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);

        return getInstance();
    }

    public BottomFluxDialog setInfoButtonText(String textBtn) {
        if (textBtn != null) {
            leftButton.setText(textBtn);
        }
        return getInstance();
    }

    public BottomFluxDialog setAlertButtonText(String textBtn) {
        if (textBtn != null) {
            leftButton.setText(textBtn);
        }
        return getInstance();
    }

    public BottomFluxDialog setLeftButtonText(String textBtn) {
        if (textBtn != null) {
            leftButton.setText(textBtn);
        }
        return getInstance();
    }

    public BottomFluxDialog setRightButtonText(String textBtn) {
        if (textBtn != null && rightButton != null) {
            rightButton.setText(textBtn);
        }
        return getInstance();
    }

    public BottomFluxDialog setTextTitle(String textTitle) {
        tvTitle.setVisibility(View.GONE);
        if (textTitle != null) {
            tvTitle.setText(textTitle);
            tvTitle.setVisibility(View.VISIBLE);
        }
        return getInstance();
    }

    public BottomFluxDialog setTextMessage(String textMessage) {
        tvMessage.setVisibility(View.GONE);
        if (textMessage != null) {
            tvMessage.setText(textMessage);
            tvMessage.setVisibility(View.VISIBLE);
        }
        return getInstance();
    }

    public BottomFluxDialog setImageDialog(int image) {
        ivDialog.setVisibility(View.GONE);
        if (image != 0) {
            ivDialog.setImageResource(image);
            ivDialog.setVisibility(View.VISIBLE);
        }
        return getInstance();
    }

    public void show() {
        if (dialog != null) {
            dialog.setContentView(view);
            dialog.show();
        }
    }

    public BottomFluxDialog setAlertListener(final OnAlertListener confirmListener) {
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (confirmListener != null) {
                    confirmListener.onClick();
                }
            }
        });
        return getInstance();
    }

    public BottomFluxDialog setConfirmListener(final OnConfirmListener confirmListener) {
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (confirmListener != null) {
                    confirmListener.onLeftClick();
                }
            }
        });
        if (rightButton != null) {
            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (confirmListener != null) {
                        confirmListener.onRightClick();
                    }
                }
            });
        }
        return getInstance();
    }

    public interface OnAlertListener {
        void onClick();
    }

    public interface OnConfirmListener {
        void onLeftClick();
        void onRightClick();
    }

    public interface LeftRightConfirmListener {
        void onLeftClick();
        void onRightRight();
    }
}
