<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet 
	version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
		
<xsl:element name="metingen">
												<xsl:element name="sum"><xsl:value-of select="sum(//bar)"/></xsl:element>
			</xsl:element>	
	</xsl:template>

</xsl:stylesheet>
