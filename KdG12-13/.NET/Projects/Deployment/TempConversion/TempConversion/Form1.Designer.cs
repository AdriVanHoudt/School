namespace TempConversion
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
      this.btnCelc = new System.Windows.Forms.Button();
      this.lblCelc = new System.Windows.Forms.Label();
      this.lblFahr = new System.Windows.Forms.Label();
      this.lblCelcConv = new System.Windows.Forms.Label();
      this.txtFah = new System.Windows.Forms.TextBox();
      this.txtCelc = new System.Windows.Forms.TextBox();
      this.lblFahrConv = new System.Windows.Forms.Label();
      this.lblCelc2 = new System.Windows.Forms.Label();
      this.lblFahr2 = new System.Windows.Forms.Label();
      this.btnToFahr = new System.Windows.Forms.Button();
      this.SuspendLayout();
      // 
      // btnCelc
      // 
      this.btnCelc.Location = new System.Drawing.Point(101, 89);
      this.btnCelc.Name = "btnCelc";
      this.btnCelc.Size = new System.Drawing.Size(75, 23);
      this.btnCelc.TabIndex = 0;
      this.btnCelc.Text = "ToCelcius";
      this.btnCelc.UseVisualStyleBackColor = true;
      this.btnCelc.Click += new System.EventHandler(this.btnCelc_Click);
      // 
      // lblCelc
      // 
      this.lblCelc.AutoSize = true;
      this.lblCelc.Location = new System.Drawing.Point(76, 61);
      this.lblCelc.Name = "lblCelc";
      this.lblCelc.Size = new System.Drawing.Size(20, 13);
      this.lblCelc.TabIndex = 1;
      this.lblCelc.Text = "C: ";
      // 
      // lblFahr
      // 
      this.lblFahr.AutoSize = true;
      this.lblFahr.Location = new System.Drawing.Point(76, 27);
      this.lblFahr.Name = "lblFahr";
      this.lblFahr.Size = new System.Drawing.Size(19, 13);
      this.lblFahr.TabIndex = 2;
      this.lblFahr.Text = "F: ";
      // 
      // lblCelcConv
      // 
      this.lblCelcConv.AutoSize = true;
      this.lblCelcConv.Location = new System.Drawing.Point(98, 61);
      this.lblCelcConv.Name = "lblCelcConv";
      this.lblCelcConv.Size = new System.Drawing.Size(16, 13);
      this.lblCelcConv.TabIndex = 3;
      this.lblCelcConv.Text = "...";
      // 
      // txtFah
      // 
      this.txtFah.Location = new System.Drawing.Point(101, 24);
      this.txtFah.Name = "txtFah";
      this.txtFah.Size = new System.Drawing.Size(100, 20);
      this.txtFah.TabIndex = 4;
      // 
      // txtCelc
      // 
      this.txtCelc.Location = new System.Drawing.Point(101, 126);
      this.txtCelc.Name = "txtCelc";
      this.txtCelc.Size = new System.Drawing.Size(100, 20);
      this.txtCelc.TabIndex = 9;
      // 
      // lblFahrConv
      // 
      this.lblFahrConv.AutoSize = true;
      this.lblFahrConv.Location = new System.Drawing.Point(98, 163);
      this.lblFahrConv.Name = "lblFahrConv";
      this.lblFahrConv.Size = new System.Drawing.Size(16, 13);
      this.lblFahrConv.TabIndex = 8;
      this.lblFahrConv.Text = "...";
      // 
      // lblCelc2
      // 
      this.lblCelc2.AutoSize = true;
      this.lblCelc2.Location = new System.Drawing.Point(76, 129);
      this.lblCelc2.Name = "lblCelc2";
      this.lblCelc2.Size = new System.Drawing.Size(20, 13);
      this.lblCelc2.TabIndex = 7;
      this.lblCelc2.Text = "C: ";
      // 
      // lblFahr2
      // 
      this.lblFahr2.AutoSize = true;
      this.lblFahr2.Location = new System.Drawing.Point(72, 163);
      this.lblFahr2.Name = "lblFahr2";
      this.lblFahr2.Size = new System.Drawing.Size(19, 13);
      this.lblFahr2.TabIndex = 6;
      this.lblFahr2.Text = "F: ";
      // 
      // btnToFahr
      // 
      this.btnToFahr.Location = new System.Drawing.Point(101, 191);
      this.btnToFahr.Name = "btnToFahr";
      this.btnToFahr.Size = new System.Drawing.Size(75, 23);
      this.btnToFahr.TabIndex = 5;
      this.btnToFahr.Text = "ToFahr";
      this.btnToFahr.UseVisualStyleBackColor = true;
      this.btnToFahr.Click += new System.EventHandler(this.btnToFahr_Click);
      // 
      // Form1
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.ClientSize = new System.Drawing.Size(284, 261);
      this.Controls.Add(this.txtCelc);
      this.Controls.Add(this.lblFahrConv);
      this.Controls.Add(this.lblCelc2);
      this.Controls.Add(this.lblFahr2);
      this.Controls.Add(this.btnToFahr);
      this.Controls.Add(this.txtFah);
      this.Controls.Add(this.lblCelcConv);
      this.Controls.Add(this.lblFahr);
      this.Controls.Add(this.lblCelc);
      this.Controls.Add(this.btnCelc);
      this.Name = "Form1";
      this.Text = "Form1";
      this.ResumeLayout(false);
      this.PerformLayout();

    }

    #endregion

    private System.Windows.Forms.Button btnCelc;
    private System.Windows.Forms.Label lblCelc;
    private System.Windows.Forms.Label lblFahr;
    private System.Windows.Forms.Label lblCelcConv;
    private System.Windows.Forms.TextBox txtFah;
    private System.Windows.Forms.TextBox txtCelc;
    private System.Windows.Forms.Label lblFahrConv;
    private System.Windows.Forms.Label lblCelc2;
    private System.Windows.Forms.Label lblFahr2;
    private System.Windows.Forms.Button btnToFahr;
  }
}

