import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";

import { addLike, removeLike } from "../../redux/post/post.actions";

import "./PostHeader.styles.css";

const PostHeader = ({
  post: { userResponse, title, likes, id },
  auth,
  addLike,
  removeLike,
}) => {
  const [likeUnlikeText, setLikeUnlikeText] = useState("Like");

  const likeOrUnlikeButton = () => (
    <button
      onClick={() => {
        if (likeUnlikeText === "Like") {
          addLike(id);
          setLikeUnlikeText("Unlike");
        } else {
          removeLike(id);
          setLikeUnlikeText("Like");
        }
      }}
      className="button is-danger mr-5"
    >
      <i className="fas fa-heart mr-2"></i> {likeUnlikeText}
    </button>
  );

  useEffect(() => {
    if (likes.filter((like) => like.user.id === auth.user.id).length === 0) {
      setLikeUnlikeText("Like");
    } else {
      setLikeUnlikeText("Unlike");
    }
    // eslint-disable-next-line
  }, [auth.user.id]);

  return (
    <div className="post-header px-5 mb-2">
      <div className="post-header-left">
        {/* <img src={user.avatar} alt="Post owner avatar" /> */}
        <img src="https://images.unsplash.com/photo-1593642634315-48f5414c3ad9?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60" alt="Post owner avatar" />
        <div className="post-header-text">
          <h1>{title}</h1>
          <h3>
            by{" "}
            <Link
              to={`/profile/${userResponse.id}`}
              className="primary-text has-text-weight-bold"
            >
              {userResponse.name}
            </Link>
          </h3>
        </div>
      </div>
      <div className="post-header-right">{likeOrUnlikeButton()}</div>
    </div>
  );
};

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps, { addLike, removeLike })(PostHeader);
