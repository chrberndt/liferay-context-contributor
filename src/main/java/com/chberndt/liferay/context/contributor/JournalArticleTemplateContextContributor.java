package com.chberndt.liferay.context.contributor;

import com.chberndt.liferay.context.contributor.util.JournalArticleUtil;

import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Christian Berndt
 */
@Component(
	immediate = true,
	property = "type=" + TemplateContextContributor.TYPE_GLOBAL,
	service = TemplateContextContributor.class
)
public class JournalArticleTemplateContextContributor
	implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects,
		HttpServletRequest httpServletRequest) {

		JournalArticleUtil journalArticleUtil = new JournalArticleUtil();

		contextObjects.put("journalArticleUtil", journalArticleUtil);
	}

}