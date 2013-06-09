<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet 
	version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
		
<xsl:element name="metingen">
				<xsl:for-each select="//bar[value&gt;100]">
								<xsl:element name="meting">
												<xsl:attribute name="number"><xsl:value-of select="position()"/></xsl:attribute>
												<xsl:value-of select="./value"/>
								</xsl:element>			
				</xsl:for-each>
			</xsl:element>	
	</xsl:template>

</xsl:stylesheet>
