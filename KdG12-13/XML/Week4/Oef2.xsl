<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet 
	version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
		
				<xsl:element name="values">
								<xsl:element name="value">
												<xsl:attribute name="number">1</xsl:attribute>
												45
								</xsl:element>
	
								<xsl:element name="value">
												<xsl:attribute name="number">2</xsl:attribute>				
												55
								</xsl:element>
								<xsl:element name="value">
												<xsl:attribute name="number">2</xsl:attribute>	
												65
								</xsl:element>

				</xsl:element>
	</xsl:template>

</xsl:stylesheet>
