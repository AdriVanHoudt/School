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

									<xsl:call-template name="draw-rectangle">

													<xsl:with-param name="left-cor" select="100"/>

													<xsl:with-param name="top-cor" select="10"/>

													<xsl:with-param name="breedte" select="220"/>

													<xsl:with-param name="hoogte" select="30"/>

													<xsl:with-param name="fill" select="'maroon'"/>

									</xsl:call-template>

									

					</xsl:element>

	</xsl:template>

	

	<xsl:template name="draw-rectangle">

					<xsl:param name="left-cor"/>

					<xsl:param name="top-cor"/>

					<xsl:param name="breedte"/>

					<xsl:param name="hoogte"/>

					<xsl:param name="fill"/>

					<xsl:element name="Rectangle">

									<xsl:attribute name="Canvas.Left"><xsl:value-of select="$left-cor"/></xsl:attribute>

									<xsl:attribute name="Canvas.Top"><xsl:value-of select="$top-cor"/></xsl:attribute>

									<xsl:attribute name="Width"><xsl:value-of select="$breedte"/></xsl:attribute>

									<xsl:attribute name="Height"><xsl:value-of select="$hoogte"/></xsl:attribute>

									<xsl:attribute name="Fill"><xsl:value-of select="$fill"/></xsl:attribute>

					</xsl:element>

	</xsl:template>

</xsl:stylesheet>
