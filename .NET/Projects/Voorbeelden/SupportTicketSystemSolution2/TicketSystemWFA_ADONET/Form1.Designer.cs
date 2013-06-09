namespace TicketSystemWFA_ADONET
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
            this.grdTickets = new System.Windows.Forms.DataGridView();
            this.bntSave = new System.Windows.Forms.Button();
            this.btnLoad = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.grdTickets)).BeginInit();
            this.SuspendLayout();
            // 
            // grdTickets
            // 
            this.grdTickets.AllowUserToAddRows = false;
            this.grdTickets.AllowUserToDeleteRows = false;
            this.grdTickets.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdTickets.Location = new System.Drawing.Point(12, 12);
            this.grdTickets.Name = "grdTickets";
            this.grdTickets.RowTemplate.Height = 24;
            this.grdTickets.Size = new System.Drawing.Size(825, 418);
            this.grdTickets.TabIndex = 0;
            // 
            // bntSave
            // 
            this.bntSave.Location = new System.Drawing.Point(562, 463);
            this.bntSave.Name = "bntSave";
            this.bntSave.Size = new System.Drawing.Size(218, 77);
            this.bntSave.TabIndex = 2;
            this.bntSave.Text = "Save";
            this.bntSave.UseVisualStyleBackColor = true;
            this.bntSave.Click += new System.EventHandler(this.bntSave_Click);
            // 
            // btnLoad
            // 
            this.btnLoad.Location = new System.Drawing.Point(59, 463);
            this.btnLoad.Name = "btnLoad";
            this.btnLoad.Size = new System.Drawing.Size(218, 77);
            this.btnLoad.TabIndex = 3;
            this.btnLoad.Text = "Load";
            this.btnLoad.UseVisualStyleBackColor = true;
            this.btnLoad.Click += new System.EventHandler(this.btnLoad_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(849, 575);
            this.Controls.Add(this.btnLoad);
            this.Controls.Add(this.bntSave);
            this.Controls.Add(this.grdTickets);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.grdTickets)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView grdTickets;
        private System.Windows.Forms.Button bntSave;
        private System.Windows.Forms.Button btnLoad;
    }
}

