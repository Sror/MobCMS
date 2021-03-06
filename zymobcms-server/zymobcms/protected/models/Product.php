<?php

/**
 * This is the model class for table "zy_product".
 *
 * The followings are the available columns in table 'zy_product':
 * @property integer $id
 * @property string $name
 * @property string $summary
 * @property string $content
 * @property double $price
 * @property string $images
 * @property string $create_time
 * @property string $update_time
 * @property integer $status
 * @property integer $create_user
 * @property integer $has_now
 * @property integer $support_count
 */
class Product extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @param string $className active record class name.
	 * @return Product the static model class
	 */
	public static function model($className=__CLASS__)
	{
		return parent::model($className);
	}

	/**
	 * @return string the associated database table name
	 */
	public function tableName()
	{
		return 'zy_product';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('name, summary, content, price', 'required'),
			array('status, create_user, has_now, support_count', 'numerical', 'integerOnly'=>true),
			array('price', 'numerical'),
			array('name', 'length', 'max'=>300),
			array('summary', 'length', 'max'=>500),
			array('content', 'length', 'max'=>1000),
			array('images', 'length', 'max'=>3000),
			array('create_time, update_time, status, create_user, has_now, support_count, images','safe'),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, name, summary, content, price, images, create_time, update_time, status, create_user, has_now, support_count', 'safe', 'on'=>'search'),
		);
	}

	/**
	 * @return array relational rules.
	 */
	public function relations()
	{
		// NOTE: you may need to adjust the relation name and the related
		// class name for the relations automatically generated below.
		return array(
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'name' => 'Name',
			'summary' => 'Summary',
			'content' => 'Content',
			'price' => 'Price',
			'images' => 'Images',
			'create_time' => 'Create Time',
			'update_time' => 'Update Time',
			'status' => 'Status',
			'create_user' => 'Create User',
			'has_now' => 'Has Now',
			'support_count' => 'Support Count',
		);
	}

	/**
	 * Retrieves a list of models based on the current search/filter conditions.
	 * @return CActiveDataProvider the data provider that can return the models based on the search/filter conditions.
	 */
	public function search()
	{
		// Warning: Please modify the following code to remove attributes that
		// should not be searched.

		$criteria=new CDbCriteria;

		$criteria->compare('id',$this->id);
		$criteria->compare('name',$this->name,true);
		$criteria->compare('summary',$this->summary,true);
		$criteria->compare('content',$this->content,true);
		$criteria->compare('price',$this->price);
		$criteria->compare('images',$this->images,true);
		$criteria->compare('create_time',$this->create_time,true);
		$criteria->compare('update_time',$this->update_time,true);
		$criteria->compare('status',$this->status);
		$criteria->compare('create_user',$this->create_user);
		$criteria->compare('has_now',$this->has_now);
		$criteria->compare('support_count',$this->support_count);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}