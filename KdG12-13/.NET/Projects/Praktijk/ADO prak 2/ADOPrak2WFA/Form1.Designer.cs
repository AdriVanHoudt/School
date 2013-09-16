namespace ADOPrak2WFA
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
            this.btnLoad = new System.Windows.Forms.Button();
            this.grdView1 = new System.Windows.Forms.DataGridView();
            this.grdView2 = new System.Windows.Forms.DataGridView();
            this.btnLoad2 = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.grdView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.grdView2)).BeginInit();
            this.SuspendLayout();
            // 
            // btnLoad
            // 
            this.btnLoad.Location = new System.Drawing.Point(12, 12);
            this.btnLoad.Name = "btnLoad";
            this.btnLoad.Size = new System.Drawing.Size(185, 221);
            this.btnLoad.TabIndex = 0;
            this.btnLoad.Text = "Toon Klanten in DatagridView";
            this.btnLoad.UseVisualStyleBackColor = true;
            this.btnLoad.Click += new System.EventHandler(this.btnLoad_Click);
            // 
            // grdView1
            // 
            this.grdView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdView1.Location = new System.Drawing.Point(203, 12);
            this.grdView1.Name = "grdView1";
            this.grdView1.RowTemplate.Height = 24;
            this.grdView1.Size = new System.Drawing.Size(769, 221);
            this.grdView1.TabIndex = 1;
            // 
            // grdView2
            // 
            this.grdView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdView2.Location = new System.Drawing.Point(203, 243);
            this.grdView2.Name = "grdView2";
            this.grdView2.RowTemplate.Height = 24;
            this.grdView2.Size = new System.Drawing.Size(769, 221);
            this.grdView2.TabIndex = 3;
            // 
            // btnLoad2
            // 
            this.btnLoad2.Location = new System.Drawing.Point(12, 243);
            this.btnLoad2.Name = "btnLoad2";
            this.btnLoad2.Size = new System.Drawing.Size(185, 221);
            this.btnLoad2.TabIndex = 2;
            this.btnLoad2.Text = "Toon Artikel gesorteerd";
            this.btnLoad2.UseVisualStyleBackColor = true;
            this.btnLoad2.Click += new System.EventHandler(this.btnLoad2_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(984, 707);
            this.Controls.Add(this.grdView2);
            this.Controls.Add(this.btnLoad2);
            this.Controls.Add(this.grdView1);
            this.Controls.Add(this.btnLoad);
            this.Name = "Form1";
            this.Text = "Adri is graaf";
            ((System.ComponentModel.ISupportInitialize)(this.grdView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.grdView2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnLoad;
        private System.Windows.Forms.DataGridView grdView1;
        private System.Windows.Forms.DataGridView grdView2;
        private System.Windows.Forms.Button btnLoad2;
    }
}

