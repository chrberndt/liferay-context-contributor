package com.chberndt.liferay.context.contributor.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutServiceUtil;

/**
 * @author Christian Berndt
 */
public class LayoutUtil {

	/**
	 * Obtain a Layout for the given parameters.
	 *
	 * @param uuid The Layout's uuid
	 * @param groupId The Layout's groupId
	 * @param privateLayout Whether the Layout is private or not.
	 *
	 * @return a Layout for the given parameters
	 */
	public Layout getLayout(String uuid, long groupId, boolean privateLayout) {
		try {
			return LayoutServiceUtil.getLayoutByUuidAndGroupId(
				uuid, groupId, privateLayout);
		}
		catch (PortalException e) {
			_log.error(e.getMessage());

			return null;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LayoutUtil.class.getName());

}