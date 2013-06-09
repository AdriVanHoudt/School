<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation" xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml">

	<xsl:output method="xml" indent="yes"/>

	<xsl:variable name="start-color" select="'Red'" />
	<xsl:variable name="end-color" select="'Ivory'" />
	
	<xsl:template match="/">
		
		<xsl:call-template name="draw-canvas"/>
		
	</xsl:template>


	<xsl:template name="draw-canvas">

					<xsl:element name="Canvas">

									<xsl:element name="Canvas.Background">

													<xsl:element name="LinearGradientBrush">

													<xsl:element name="GradientStop">

																	<xsl:attribute name="Color" ><xsl:value-of select="$start-color"/></xsl:attribute>

													</xsl:element>

													<xsl:element name="GradientStop">

																	<xsl:attribute name="Color"><xsl:value-of select="$end-color"/></xsl:attribute>

																	<xsl:attribute name="Offset"><xsl:value-of select="1"/></xsl:attribute>

													</xsl:element>

													</xsl:element>

									</xsl:element>

					</xsl:element>

	</xsl:template>

</xsl:stylesheet>
