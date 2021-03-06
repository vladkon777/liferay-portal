/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.social.networking.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.social.networking.model.MeetupsRegistration;
import com.liferay.social.networking.model.MeetupsRegistrationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MeetupsRegistration service. Represents a row in the &quot;MeetupsRegistration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link MeetupsRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MeetupsRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MeetupsRegistrationImpl
 * @see MeetupsRegistration
 * @see MeetupsRegistrationModel
 * @generated
 */
@ProviderType
public class MeetupsRegistrationModelImpl extends BaseModelImpl<MeetupsRegistration>
	implements MeetupsRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a meetups registration model instance should use the {@link MeetupsRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "MeetupsRegistration";
	public static final Object[][] TABLE_COLUMNS = {
			{ "meetupsRegistrationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "meetupsEntryId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "comments", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table MeetupsRegistration (meetupsRegistrationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,meetupsEntryId LONG,status INTEGER,comments VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table MeetupsRegistration";
	public static final String ORDER_BY_JPQL = " ORDER BY meetupsRegistration.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY MeetupsRegistration.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.social.networking.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.social.networking.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.social.networking.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.social.networking.model.MeetupsRegistration"),
			true);
	public static final long MEETUPSENTRYID_COLUMN_BITMASK = 1L;
	public static final long STATUS_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.social.networking.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.social.networking.model.MeetupsRegistration"));

	public MeetupsRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeetupsRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MeetupsRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return MeetupsRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("meetupsRegistrationId", getMeetupsRegistrationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("meetupsEntryId", getMeetupsEntryId());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long meetupsRegistrationId = (Long)attributes.get(
				"meetupsRegistrationId");

		if (meetupsRegistrationId != null) {
			setMeetupsRegistrationId(meetupsRegistrationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long meetupsEntryId = (Long)attributes.get("meetupsEntryId");

		if (meetupsEntryId != null) {
			setMeetupsEntryId(meetupsEntryId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public long getMeetupsRegistrationId() {
		return _meetupsRegistrationId;
	}

	@Override
	public void setMeetupsRegistrationId(long meetupsRegistrationId) {
		_meetupsRegistrationId = meetupsRegistrationId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getMeetupsEntryId() {
		return _meetupsEntryId;
	}

	@Override
	public void setMeetupsEntryId(long meetupsEntryId) {
		_columnBitmask |= MEETUPSENTRYID_COLUMN_BITMASK;

		if (!_setOriginalMeetupsEntryId) {
			_setOriginalMeetupsEntryId = true;

			_originalMeetupsEntryId = _meetupsEntryId;
		}

		_meetupsEntryId = meetupsEntryId;
	}

	public long getOriginalMeetupsEntryId() {
		return _originalMeetupsEntryId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MeetupsRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MeetupsRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MeetupsRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MeetupsRegistrationImpl meetupsRegistrationImpl = new MeetupsRegistrationImpl();

		meetupsRegistrationImpl.setMeetupsRegistrationId(getMeetupsRegistrationId());
		meetupsRegistrationImpl.setCompanyId(getCompanyId());
		meetupsRegistrationImpl.setUserId(getUserId());
		meetupsRegistrationImpl.setUserName(getUserName());
		meetupsRegistrationImpl.setCreateDate(getCreateDate());
		meetupsRegistrationImpl.setModifiedDate(getModifiedDate());
		meetupsRegistrationImpl.setMeetupsEntryId(getMeetupsEntryId());
		meetupsRegistrationImpl.setStatus(getStatus());
		meetupsRegistrationImpl.setComments(getComments());

		meetupsRegistrationImpl.resetOriginalValues();

		return meetupsRegistrationImpl;
	}

	@Override
	public int compareTo(MeetupsRegistration meetupsRegistration) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				meetupsRegistration.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MeetupsRegistration)) {
			return false;
		}

		MeetupsRegistration meetupsRegistration = (MeetupsRegistration)obj;

		long primaryKey = meetupsRegistration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		MeetupsRegistrationModelImpl meetupsRegistrationModelImpl = this;

		meetupsRegistrationModelImpl._originalUserId = meetupsRegistrationModelImpl._userId;

		meetupsRegistrationModelImpl._setOriginalUserId = false;

		meetupsRegistrationModelImpl._setModifiedDate = false;

		meetupsRegistrationModelImpl._originalMeetupsEntryId = meetupsRegistrationModelImpl._meetupsEntryId;

		meetupsRegistrationModelImpl._setOriginalMeetupsEntryId = false;

		meetupsRegistrationModelImpl._originalStatus = meetupsRegistrationModelImpl._status;

		meetupsRegistrationModelImpl._setOriginalStatus = false;

		meetupsRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MeetupsRegistration> toCacheModel() {
		MeetupsRegistrationCacheModel meetupsRegistrationCacheModel = new MeetupsRegistrationCacheModel();

		meetupsRegistrationCacheModel.meetupsRegistrationId = getMeetupsRegistrationId();

		meetupsRegistrationCacheModel.companyId = getCompanyId();

		meetupsRegistrationCacheModel.userId = getUserId();

		meetupsRegistrationCacheModel.userName = getUserName();

		String userName = meetupsRegistrationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			meetupsRegistrationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			meetupsRegistrationCacheModel.createDate = createDate.getTime();
		}
		else {
			meetupsRegistrationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			meetupsRegistrationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			meetupsRegistrationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		meetupsRegistrationCacheModel.meetupsEntryId = getMeetupsEntryId();

		meetupsRegistrationCacheModel.status = getStatus();

		meetupsRegistrationCacheModel.comments = getComments();

		String comments = meetupsRegistrationCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			meetupsRegistrationCacheModel.comments = null;
		}

		return meetupsRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{meetupsRegistrationId=");
		sb.append(getMeetupsRegistrationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", meetupsEntryId=");
		sb.append(getMeetupsEntryId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.social.networking.model.MeetupsRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>meetupsRegistrationId</column-name><column-value><![CDATA[");
		sb.append(getMeetupsRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetupsEntryId</column-name><column-value><![CDATA[");
		sb.append(getMeetupsEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = MeetupsRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			MeetupsRegistration.class
		};
	private long _meetupsRegistrationId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _meetupsEntryId;
	private long _originalMeetupsEntryId;
	private boolean _setOriginalMeetupsEntryId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private String _comments;
	private long _columnBitmask;
	private MeetupsRegistration _escapedModel;
}