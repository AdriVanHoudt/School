<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet 
	version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
		
<xsl:element name="metingen">
												<xsl:element name="min"><xsl:value-of select="min(//bar)"/></xsl:element>
												<xsl:element name="max"><xsl:value-of select="max(//bar)"/></xsl:element>
												<xsl:element name="avg"><xsl:value-of select="avg(//bar)"/></xsl:element>
			</xsl:element>	
	</xsl:template>

</xsl:stylesheet>
