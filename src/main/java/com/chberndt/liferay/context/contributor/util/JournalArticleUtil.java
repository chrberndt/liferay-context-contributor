package com.chberndt.liferay.context.contributor.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

/**
 * @author Christian Berndt
 */
public class JournalArticleUtil {

	/**
	 * Retrieve an article identified by <strong>articleId</strong>.
	 *
	 * @param groupId
	 * @param articleId
	 * @return the first level dynamic-element node identified by <strong>instanceId</strong>.
	 */
	public JournalArticle getArticle(long groupId, String articleId) {
		try {
			return JournalArticleServiceUtil.getArticle(groupId, articleId);
		}
		catch (PortalException e) {
			_log.error(e.getMessage());

			return null;
		}
	}

	/**
	 * Retrieve the first level node from an article identified by <strong>instanceId</strong>.
	 * Useful especially for structures with repeatable field groups.
	 *
	 * @param groupId
	 * @param articleId
	 * @param instanceId
	 * @return the first level dynamic-element node identified by <strong>instanceId</strong>.
	 */
	public Node getArticleNode(
		long groupId, String articleId, String instanceId) {

		JournalArticle article = getArticle(groupId, articleId);

		Document document;

		try {
			document = SAXReaderUtil.read(article.getContent());

			Element root = document.getRootElement();

			return root.selectSingleNode(
				"./dynamic-element[@instance-id='" + instanceId + "']");
		}
		catch (DocumentException e) {
			_log.error(e.getMessage());

			return null;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		JournalArticleUtil.class.getName());

}