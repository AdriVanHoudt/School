<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation" xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml">

	<xsl:output method="xml" indent="yes"/>

	<xsl:template match="/">
		
		<xsl:call-template name="draw-canvas">
						<xsl:with-param name="begin" select="'Red'"/>
						<xsl:with-param name="end" select="'Ivory'"/>
		</xsl:call-template>
		
	</xsl:template>


	<xsl:template name="draw-canvas">

					<xsl:param name="begin"/>
					<xsl:param name="end"/>					

					<xsl:element name="Canvas">

									<xsl:element name="Canvas.Background">

													<xsl:element name="LinearGradientBrush">

													<xsl:element name="GradientStop">

																	<xsl:attribute name="Color" ><xsl:value-of select="$begin"/></xsl:attribute>

													</xsl:element>

													<xsl:element name="GradientStop">

																	<xsl:attribute name="Color"><xsl:value-of select="$end"/></xsl:attribute>

																	<xsl:attribute name="Offset"><xsl:value-of select="1"/></xsl:attribute>

													</xsl:element>

													</xsl:element>

									</xsl:element>

					</xsl:element>

	</xsl:template>

</xsl:stylesheet>
