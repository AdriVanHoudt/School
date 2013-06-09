namespace HogerLager
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblInfo = new System.Windows.Forms.Label();
            this.txtInput = new System.Windows.Forms.TextBox();
            this.lblBoodschap = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnStop = new System.Windows.Forms.Button();
            this.btnEvalueer = new System.Windows.Forms.Button();
            this.btnNieuwSpel = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblInfo
            // 
            this.lblInfo.AutoSize = true;
            this.lblInfo.Location = new System.Drawing.Point(174, 28);
            this.lblInfo.Name = "lblInfo";
            this.lblInfo.Size = new System.Drawing.Size(261, 34);
            this.lblInfo.TabIndex = 0;
            this.lblInfo.Text = "Geef een getal van 1 tot 100 en druk op\r\nde TAB toets";
            this.lblInfo.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // txtInput
            // 
            this.txtInput.Enabled = false;
            this.txtInput.Location = new System.Drawing.Point(267, 65);
            this.txtInput.Multiline = true;
            this.txtInput.Name = "txtInput";
            this.txtInput.Size = new System.Drawing.Size(78, 39);
            this.txtInput.TabIndex = 1;
            this.txtInput.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtInput.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtInput_KeyPress);
            // 
            // lblBoodschap
            // 
            this.lblBoodschap.Location = new System.Drawing.Point(239, 107);
            this.lblBoodschap.Name = "lblBoodschap";
            this.lblBoodschap.Size = new System.Drawing.Size(137, 23);
            this.lblBoodschap.TabIndex = 0;
            this.lblBoodschap.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnStop);
            this.groupBox1.Controls.Add(this.btnEvalueer);
            this.groupBox1.Controls.Add(this.btnNieuwSpel);
            this.groupBox1.Location = new System.Drawing.Point(12, 133);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(585, 112);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Maak hier uw keuze";
            // 
            // btnStop
            // 
            this.btnStop.Location = new System.Drawing.Point(407, 21);
            this.btnStop.Name = "btnStop";
            this.btnStop.Size = new System.Drawing.Size(106, 85);
            this.btnStop.TabIndex = 2;
            this.btnStop.Text = "&Stop";
            this.btnStop.UseVisualStyleBackColor = true;
            this.btnStop.Click += new System.EventHandler(this.btnStop_Click);
            // 
            // btnEvalueer
            // 
            this.btnEvalueer.Enabled = false;
            this.btnEvalueer.Location = new System.Drawing.Point(239, 21);
            this.btnEvalueer.Name = "btnEvalueer";
            this.btnEvalueer.Size = new System.Drawing.Size(106, 85);
            this.btnEvalueer.TabIndex = 1;
            this.btnEvalueer.Text = "&Evalueer";
            this.btnEvalueer.UseVisualStyleBackColor = true;
            this.btnEvalueer.Click += new System.EventHandler(this.btnEvalueer_Click);
            // 
            // btnNieuwSpel
            // 
            this.btnNieuwSpel.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNieuwSpel.Location = new System.Drawing.Point(71, 21);
            this.btnNieuwSpel.Name = "btnNieuwSpel";
            this.btnNieuwSpel.Size = new System.Drawing.Size(106, 85);
            this.btnNieuwSpel.TabIndex = 0;
            this.btnNieuwSpel.Text = "&Nieuw Spel";
            this.btnNieuwSpel.UseVisualStyleBackColor = true;
            this.btnNieuwSpel.Click += new System.EventHandler(this.btnNieuwSpel_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(609, 262);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.lblBoodschap);
            this.Controls.Add(this.txtInput);
            this.Controls.Add(this.lblInfo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblInfo;
        private System.Windows.Forms.TextBox txtInput;
        private System.Windows.Forms.Label lblBoodschap;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnStop;
        private System.Windows.Forms.Button btnEvalueer;
        private System.Windows.Forms.Button btnNieuwSpel;
    }
}

