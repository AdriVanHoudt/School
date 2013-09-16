<?php

/* AdriNewsBundle:Default:index.html.twig */
class __TwigTemplate_cd8f47186db7898360efa825d523a01a extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "articles"));
        $context['_iterated'] = false;
        foreach ($context['_seq'] as $context["_key"] => $context["article"]) {
            // line 2
            echo "    <div class=\"news_post\">
        <div class=\"news_header\">";
            // line 3
            echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "article"), "title"), "html", null, true);
            echo "</div>
        <div class=\"news_content\">
            ";
            // line 5
            echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "article"), "content"), "html", null, true);
            echo "
        </div>
        <div class=\"news_footer\">";
            // line 7
            echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "article"), "postedBy"), "html", null, true);
            echo " on ";
            echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute($this->getContext($context, "article"), "dateAdded"), "d/m/Y"), "html", null, true);
            echo "</div>
    </div>
";
            $context['_iterated'] = true;
        }
        if (!$context['_iterated']) {
            // line 10
            echo "    <div class=\"error error-alert\">No Articles found</div>
";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['article'], $context['_parent'], $context['loop']);
        $context = array_merge($_parent, array_intersect_key($context, $_parent));
    }

    public function getTemplateName()
    {
        return "AdriNewsBundle:Default:index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  47 => 10,  37 => 7,  32 => 5,  27 => 3,  24 => 2,  19 => 1,);
    }
}
