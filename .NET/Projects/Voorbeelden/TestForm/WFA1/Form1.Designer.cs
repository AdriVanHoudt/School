namespace WFA1
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
            this.btnJos = new System.Windows.Forms.Button();
            this.txtInput = new System.Windows.Forms.TextBox();
            this.lblInfo = new System.Windows.Forms.Label();
            this.lnkHyperLink = new System.Windows.Forms.LinkLabel();
            this.chkSetting1 = new System.Windows.Forms.CheckBox();
            this.chkSetting2 = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // btnJos
            // 
            this.btnJos.Location = new System.Drawing.Point(266, 12);
            this.btnJos.Name = "btnJos";
            this.btnJos.Size = new System.Drawing.Size(143, 39);
            this.btnJos.TabIndex = 0;
            this.btnJos.Text = "drukt op mijne knop";
            this.btnJos.UseVisualStyleBackColor = true;
            this.btnJos.Click += new System.EventHandler(this.btnJos_Click);
            // 
            // txtInput
            // 
            this.txtInput.Location = new System.Drawing.Point(12, 20);
            this.txtInput.Name = "txtInput";
            this.txtInput.Size = new System.Drawing.Size(223, 22);
            this.txtInput.TabIndex = 1;
            this.txtInput.TextChanged += new System.EventHandler(this.txtInput_TextChanged);
            // 
            // lblInfo
            // 
            this.lblInfo.AutoSize = true;
            this.lblInfo.Location = new System.Drawing.Point(9, 58);
            this.lblInfo.Name = "lblInfo";
            this.lblInfo.Size = new System.Drawing.Size(46, 17);
            this.lblInfo.TabIndex = 2;
            this.lblInfo.Text = "label1";
            // 
            // lnkHyperLink
            // 
            this.lnkHyperLink.AutoSize = true;
            this.lnkHyperLink.Location = new System.Drawing.Point(266, 58);
            this.lnkHyperLink.Name = "lnkHyperLink";
            this.lnkHyperLink.Size = new System.Drawing.Size(82, 17);
            this.lnkHyperLink.TabIndex = 3;
            this.lnkHyperLink.TabStop = true;
            this.lnkHyperLink.Text = "www.kdg.be";
            // 
            // chkSetting1
            // 
            this.chkSetting1.AutoSize = true;
            this.chkSetting1.Location = new System.Drawing.Point(12, 102);
            this.chkSetting1.Name = "chkSetting1";
            this.chkSetting1.Size = new System.Drawing.Size(98, 21);
            this.chkSetting1.TabIndex = 4;
            this.chkSetting1.Tag = "pom";
            this.chkSetting1.Text = "checkBox1";
            this.chkSetting1.UseVisualStyleBackColor = true;
            this.chkSetting1.CheckedChanged += new System.EventHandler(this.chkSetting_CheckedChanged);
            // 
            // chkSetting2
            // 
            this.chkSetting2.AutoSize = true;
            this.chkSetting2.Location = new System.Drawing.Point(12, 129);
            this.chkSetting2.Name = "chkSetting2";
            this.chkSetting2.Size = new System.Drawing.Size(98, 21);
            this.chkSetting2.TabIndex = 5;
            this.chkSetting2.Tag = "pom2";
            this.chkSetting2.Text = "checkBox2";
            this.chkSetting2.UseVisualStyleBackColor = true;
            this.chkSetting2.CheckedChanged += new System.EventHandler(this.chkSetting_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(421, 265);
            this.Controls.Add(this.chkSetting2);
            this.Controls.Add(this.chkSetting1);
            this.Controls.Add(this.lnkHyperLink);
            this.Controls.Add(this.lblInfo);
            this.Controls.Add(this.txtInput);
            this.Controls.Add(this.btnJos);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnJos;
        private System.Windows.Forms.TextBox txtInput;
        private System.Windows.Forms.Label lblInfo;
        private System.Windows.Forms.LinkLabel lnkHyperLink;
        private System.Windows.Forms.CheckBox chkSetting1;
        private System.Windows.Forms.CheckBox chkSetting2;
    }
}

